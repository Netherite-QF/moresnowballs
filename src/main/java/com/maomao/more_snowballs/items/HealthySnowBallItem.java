
package com.maomao.more_snowballs.items;

import com.maomao.more_snowballs.MoreSnowballs;
import com.maomao.more_snowballs.entity.snowballs.HealthySnowballEntity;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealthySnowBallItem extends Item {
    public HealthySnowBallItem(Item.Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL, 1.0F, 0.33F);
        if (!world.isClient) {
            HealthySnowballEntity HealthySnowballEntity = new HealthySnowballEntity(world, user);
            HealthySnowballEntity.setItem(itemStack);
            HealthySnowballEntity.setVelocity(user, user.prevPitch, user.bodyYaw, 0.0F, 1.5F, 0.0F);
            world.spawnEntity(HealthySnowballEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
            user.getItemCooldownManager().set(MoreSnowballs.HealthySnowBallItem, 25);
            user.addExperience(-5);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.more_snowballs.healthy_snowball.tooltip").formatted(Formatting.GRAY));
    }
}
