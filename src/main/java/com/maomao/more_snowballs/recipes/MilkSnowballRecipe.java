
package com.maomao.more_snowballs.recipes;

import com.google.common.collect.Lists;
import com.maomao.more_snowballs.MoreSnowballs;
import java.util.ArrayList;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class MilkSnowballRecipe extends SpecialCraftingRecipe {
    private int MilkSnowballSlot = 0;

    public MilkSnowballRecipe(Identifier id) {
        super(id);
    }

    public boolean matches(CraftingInventory inventory, World world) {
        ArrayList<ItemStack> list = Lists.newArrayList();

        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                if (stack.getItem() == Items.SNOWBALL) {
                    list.add(stack);
                } else if (stack.getItem() == Items.MILK_BUCKET) {
                    list.add(stack);
                }
            }
        }

        return list.size() == 2;
    }

    public ItemStack craft(CraftingInventory inventory) {
        boolean hasMilkBucket = false;
        boolean hasSnowball = false;
        int count = 0;

        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()) {
                ++count;
                if (stack.getItem() == Items.SNOWBALL) {
                    hasSnowball = true;
                } else if (stack.getItem() == Items.MILK_BUCKET) {
                    hasMilkBucket = true;
                    this.MilkSnowballSlot = i;
                }
            }
        }

        if (hasSnowball && hasMilkBucket && count == 2) {
            return MoreSnowballs.MilkSnowBallItem.getDefaultStack();
        } else {
            return ItemStack.EMPTY;
        }
    }

    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> list = DefaultedList.ofSize(9, ItemStack.EMPTY);
        list.set(this.MilkSnowballSlot, new ItemStack(Items.BUCKET));
        return list;
    }

    public RecipeSerializer<?> getSerializer() {
        return MoreSnowballs.MILK_SNOWBALL_RECIPE;
    }
}
