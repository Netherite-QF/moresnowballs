
package com.maomao.more_snowballs.entity.snowballs;

import com.maomao.more_snowballs.MoreSnowballs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class SlimeSnowballEntity extends ThrownItemEntity {
    /*public SlimeSnowballEntity(EntityType<? extends SlimeSnowballEntity> entityType, World world) {
        super(entityType, world);
    }*/

    public SlimeSnowballEntity(World world, LivingEntity owner) {
        super(MoreSnowballs.SLIME_SNOW_BALL_ENTITY_ENTITY_TYPE, owner, world);
    }

    public SlimeSnowballEntity(World world, double x, double y, double z) {
        super(MoreSnowballs.SLIME_SNOW_BALL_ENTITY_ENTITY_TYPE, x, y, z, world);
    }

    public SlimeSnowballEntity(EntityType<Entity> entityEntityType, World world) {
        super(EntityType.SNOWBALL, world);
    }

    protected Item getDefaultItem() {
        return MoreSnowballs.SlimeSnowBallItem;
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
        int i = 2;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float) i);
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(MoreSnowballs.SLIME, 300, 1));
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
