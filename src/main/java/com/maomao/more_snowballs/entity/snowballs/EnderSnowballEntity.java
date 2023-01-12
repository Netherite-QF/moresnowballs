
package com.maomao.more_snowballs.entity.snowballs;

import com.maomao.more_snowballs.MoreSnowballs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class EnderSnowballEntity extends ThrownItemEntity {
    public EnderSnowballEntity(EntityType<? extends EnderSnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public EnderSnowballEntity(World world, LivingEntity owner) {
        super(MoreSnowballs.ENDER_SNOWBALL_ENTITY_ENTITY_TYPE, owner, world);
    }

    public EnderSnowballEntity(World world, double x, double y, double z) {
        super(MoreSnowballs.ENDER_SNOWBALL_ENTITY_ENTITY_TYPE, x, y, z, world);
    }

    protected Item getDefaultItem() {
        return MoreSnowballs.EnderSnowBallItem;
    }

    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return (ParticleEffect) (itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL
                : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }

    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = 1;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float) i);
        entity.requestTeleport(entity.getX(), entity.getY() + 4.5, entity.getZ());
        this.world.playSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT,
                SoundCategory.AMBIENT, 1.0F, 1.0F, true);

        for (int j = 0; j < 32; ++j) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0,
                    this.getZ(), this.random.nextGaussian(), 0.0, this.random.nextGaussian());
        }

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.setFireTicks(0);
        }

    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte) 3);
            this.discard();
        }

    }
}
