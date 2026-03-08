package net.nightmaresmc.potp.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class StaffItem extends Item {

    public StaffItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(stack);
        }

        if (!world.isClient) {

            // SHIFT + RIGHT CLICK (FLAME SHOCKWAVE)
            if (user.isSneaking()) {

                double radius = 10;

                List<LivingEntity> entities = world.getEntitiesByClass(
                        LivingEntity.class,
                        new Box(
                                user.getX() - radius,
                                user.getY() - radius,
                                user.getZ() - radius,
                                user.getX() + radius,
                                user.getY() + radius,
                                user.getZ() + radius
                        ),
                        entity -> entity != user
                );

                for (LivingEntity target : entities) {

                    target.setOnFireFor(6);
                    target.damage(world.getDamageSources().playerAttack(user), 6f);

                    Vec3d knockback = target.getPos().subtract(user.getPos()).normalize().multiply(1.5);
                    target.addVelocity(knockback.x, 0.5, knockback.z);
                }

                // IGNITE GROUND
                int fireRadius = 10;

                for (int x = -fireRadius; x <= fireRadius; x++) {
                    for (int z = -fireRadius; z <= fireRadius; z++) {

                        BlockPos pos = user.getBlockPos().add(x, 0, z);
                        BlockPos above = pos.up();

                        if (world.getBlockState(above).isAir()) {
                            world.setBlockState(above, Blocks.FIRE.getDefaultState());
                        }
                    }
                }

                // PARTICLES
                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.FLAME,
                        user.getX(),
                        user.getY() + 1,
                        user.getZ(),
                        80,
                        2,
                        1,
                        2,
                        0.05
                );

                // SOUND
                world.playSound(
                        null,
                        user.getBlockPos(),
                        SoundEvents.ITEM_TOTEM_USE,
                        SoundCategory.PLAYERS,
                        1.4f,
                        0.7f
                );

                // EXPLOSION (NO SELF DAMAGE)
                world.createExplosion(
                        user,
                        null,
                        null,
                        user.getX(),
                        user.getY(),
                        user.getZ(),
                        5.0f,
                        true,
                        World.ExplosionSourceType.MOB
                );

                user.getItemCooldownManager().set(this, 80);
            }

            // NORMAL RIGHT CLICK (FIREBALL)
            else {

                Vec3d look = user.getRotationVector();
                Vec3d spawnPos = user.getEyePos();

                SmallFireballEntity fireball = new SmallFireballEntity(
                        world,
                        spawnPos.x,
                        spawnPos.y,
                        spawnPos.z,
                        look
                );

                world.spawnEntity(fireball);

                // SOUND
                world.playSound(
                        null,
                        user.getBlockPos(),
                        SoundEvents.ITEM_FIRECHARGE_USE,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );

                user.getItemCooldownManager().set(this, 30);
            }
        }

        return TypedActionResult.success(stack, world.isClient()); //
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.staff.tooltip.1"));
        tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.staff.tooltip.2"));
        tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.staff.tooltip.3"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}