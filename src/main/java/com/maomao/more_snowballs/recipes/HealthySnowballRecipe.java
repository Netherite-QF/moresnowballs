
package com.maomao.more_snowballs.recipes;

import com.google.common.collect.Lists;
import com.maomao.more_snowballs.MoreSnowballs;
import java.util.ArrayList;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class HealthySnowballRecipe extends SpecialCraftingRecipe {
    private int HealthySnowballSlot = 0;

    public HealthySnowballRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    public boolean matches(CraftingInventory inventory, World world) {
        ArrayList<ItemStack> list = Lists.newArrayList();

        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() == Items.SNOWBALL) {
                    list.add(stack);
                } else if (stack.getItem() instanceof PotionItem
                        && PotionUtil.getPotionEffects(stack).stream().anyMatch((instance) -> {
                            return instance.getEffectType() == StatusEffects.INSTANT_HEALTH;
                        })) {
                    list.add(stack);
                }
            }
        }

        return list.size() == 2;
    }

    public ItemStack craft(CraftingInventory inventory) {
        boolean hasPotion = false;
        boolean hasSnowball = false;
        int count = 0;

        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                ++count;
                if (stack.getItem() == Items.SNOWBALL) {
                    hasSnowball = true;
                } else if (stack.getItem() instanceof PotionItem
                        && PotionUtil.getPotionEffects(stack).stream().anyMatch((instance) -> {
                            return instance.getEffectType() == StatusEffects.INSTANT_HEALTH;
                        })) {
                    hasPotion = true;
                    this.HealthySnowballSlot = i;
                }
            }
        }

        if (hasSnowball && hasPotion && count == 2) {
            return MoreSnowballs.HealthySnowBallItem.getDefaultStack();
        } else {
            return ItemStack.EMPTY;
        }
    }

    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> list = DefaultedList.ofSize(9, ItemStack.EMPTY);
        list.set(this.HealthySnowballSlot, new ItemStack(Items.GLASS_BOTTLE));
        return list;
    }

    public RecipeSerializer<?> getSerializer() {
        return MoreSnowballs.HEALTHY_SNOWBALL_RECIPE;
    }
}
