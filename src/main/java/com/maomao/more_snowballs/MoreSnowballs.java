//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.maomao.more_snowballs;

import com.maomao.more_snowballs.effects.SlimeStatusEffect;
import com.maomao.more_snowballs.entity.snowballs.*;
import com.maomao.more_snowballs.items.*;
import com.maomao.more_snowballs.recipes.ExpSnowballRecipe;
import com.maomao.more_snowballs.recipes.HealthySnowballRecipe;
import com.maomao.more_snowballs.recipes.MilkSnowballRecipe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MoreSnowballs implements ModInitializer {
    public static final String MODID = "more_snowballs";
    public static final RecipeSerializer<HealthySnowballRecipe> HEALTHY_SNOWBALL_RECIPE = RecipeSerializer.register("crafting_healthy_snowball", new SpecialRecipeSerializer(HealthySnowballRecipe::new));
    public static final RecipeSerializer<MilkSnowballRecipe> MILK_SNOWBALL_RECIPE = RecipeSerializer.register("crafting_milk_snowball", new SpecialRecipeSerializer(MilkSnowballRecipe::new));
    public static final RecipeSerializer<ExpSnowballRecipe> EXP_SNOWBALL_RECIPE = RecipeSerializer.register("crafting_exp_snowball", new SpecialRecipeSerializer(ExpSnowballRecipe::new));
    public static final Item CRUSHED_ICE;
    public static final Item WITHER_BONE;
    public static final Item POWDER_SNOW_DUST;
    public static final Item STONE_NUGGET;
    public static final Item IceSnowBallItem;
    public static final Item SlimeSnowBallItem;
    public static final Item SpectralSnowBallItem;
    public static final Item WitherSnowBallItem;
    public static final Item AmethystSnowBallItem;
    public static final Item StoneNuggetSnowBallItem;
    public static final Item GunpowderSnowBallItem;
    public static final Item PowderSnowBallItem;
    public static final Item GlowInkSnowBallItem;
    public static final Item BrickSnowBallItem;
    public static final Item ObsidianSnowBallItem;
    public static final Item EnderSnowBallItem;
    public static final Item MilkSnowBallItem;
    public static final Item HealthySnowBallItem;
    public static final Item ExpSnowBallItem;
    public static final Item DarknessSnowBallItem;
    public static final StatusEffect SLIME;
    public static final EntityType<IceSnowballEntity> ICE_SNOWBALLS_ENTITY_ENTITY_TYPE;
    public static final EntityType<SlimeSnowballEntity> SLIME_SNOW_BALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<SpectralSnowballEntity> SPECTRAL_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<WitherSnowballEntity> WITHER_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<AmethystSnowballEntity> AMETHYST_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<PowderSnowBallEntity> POWDER_SNOW_BALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<StoneNuggetSnowballEntity> STONE_NUGGET_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<GunpowderSnowballEntity> GUNPOWDER_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<GlowInkSnowballEntity> GLOW_INK_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<BrickSnowballEntity> BRICK_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<ObsidianSnowballEntity> OBSIDIAN_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<EnderSnowballEntity> ENDER_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<MilkSnowballEntity> MILK_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<HealthySnowballEntity> HEALTHY_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<ExpSnowballEntity> EXP_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static final EntityType<DarknessSnowballEntity> DARKNESS_SNOWBALL_ENTITY_ENTITY_TYPE;
    public static ItemGroup MORE_SNOWBALLS_GROUP;

    public MoreSnowballs() {
    }

    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "ice_snowball"), IceSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "slime_snowball"), SlimeSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "spectral_snowball"), SpectralSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "crushed_ice"), CRUSHED_ICE);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("more_snowballs", "slime"), SLIME);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "wither_bone"), WITHER_BONE);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "powder_snow_dust"), POWDER_SNOW_DUST);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "stone_nugget"), STONE_NUGGET);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "wither_snowball"), WitherSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "amethyst_snowball"), AmethystSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "powder_snow_ball"), PowderSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "stone_nugget_snowball"),
                StoneNuggetSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "gunpowder_snowball"), GunpowderSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "glow_ink_snowball"), GlowInkSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "brick_snowball"), BrickSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "obsidian_snowball"), ObsidianSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "ender_snowball"), EnderSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "milk_snowball"), MilkSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "healthy_snowball"), HealthySnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "exp_snowball"), ExpSnowBallItem);
        Registry.register(Registries.ITEM, new Identifier("more_snowballs", "darkness_snowball"), DarknessSnowBallItem);
    }

    static {
        CRUSHED_ICE = new Item((new Item.Settings()));
        WITHER_BONE = new Item((new Item.Settings()));
        POWDER_SNOW_DUST = new Item((new Item.Settings()));
        STONE_NUGGET = new Item((new Item.Settings()));
        IceSnowBallItem = new IceSnowBallItem((new Item.Settings()).maxCount(16));
        SlimeSnowBallItem = new SlimeSnowBallItem((new Item.Settings()).maxCount(16));
        SpectralSnowBallItem = new SpectralSnowBallItem((new Item.Settings()).maxCount(16));
        WitherSnowBallItem = new WitherSnowBallItem((new Item.Settings()).maxCount(16));
        AmethystSnowBallItem = new AmethystSnowBallItem((new Item.Settings()).maxCount(16));
        StoneNuggetSnowBallItem = new StoneNuggetSnowBallItem((new Item.Settings()).maxCount(16));
        GunpowderSnowBallItem = new GunpowderSnowBallItem((new Item.Settings()).maxCount(16));
        PowderSnowBallItem = new PowderSnowBallItem((new Item.Settings()).maxCount(32));
        GlowInkSnowBallItem = new GlowInkSnowBallItem((new Item.Settings()).maxCount(16));
        BrickSnowBallItem = new BrickSnowBallItem((new Item.Settings()).maxCount(16));
        ObsidianSnowBallItem = new ObsidianSnowBallItem((new Item.Settings()).maxCount(16));
        EnderSnowBallItem = new EnderSnowBallItem((new Item.Settings()).maxCount(16));
        MilkSnowBallItem = new MilkSnowBallItem((new Item.Settings()).maxCount(16));
        HealthySnowBallItem = new HealthySnowBallItem((new Item.Settings()).maxCount(16));
        ExpSnowBallItem = new ExpSnowBallItem((new Item.Settings()).maxCount(16));
        DarknessSnowBallItem = new DarknessSnowBallItem((new Item.Settings()).maxCount(16));
        SLIME = (new SlimeStatusEffect()).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        ICE_SNOWBALLS_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "ice_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, IceSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        SLIME_SNOW_BALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "slime_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlimeSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        SPECTRAL_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "spectral_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, SpectralSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        WITHER_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "wither_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, WitherSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        AMETHYST_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "amethyst_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, AmethystSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        POWDER_SNOW_BALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "powder_snow_ball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, PowderSnowBallEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        STONE_NUGGET_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "stone_nugget_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, StoneNuggetSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        GUNPOWDER_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "gunpowder_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, GunpowderSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        GLOW_INK_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "glow_ink_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, GlowInkSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        BRICK_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "brick_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, BrickSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        OBSIDIAN_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "obsidian_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, ObsidianSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        ENDER_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "ender_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, EnderSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        MILK_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "milk_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, MilkSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        HEALTHY_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "healthy_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, HealthySnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        EXP_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "exp_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, ExpSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        DARKNESS_SNOWBALL_ENTITY_ENTITY_TYPE = (EntityType) Registry.register(Registries.ENTITY_TYPE,
                new Identifier("more_snowballs", "darkness_snowball"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, DarknessSnowballEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());
        /*MORE_SNOWBALLS_GROUP = FabricItemGroupBuilder.create(new Identifier("more_snowballs", "more_snowballs_group"))
                .icon(() -> {
                    return new ItemStack(IceSnowBallItem);
                }).appendItems((ItemStack) -> {
                    ItemStack.add(new ItemStack(CRUSHED_ICE));
                    ItemStack.add(new ItemStack(POWDER_SNOW_DUST));
                    ItemStack.add(new ItemStack(STONE_NUGGET));
                    ItemStack.add(new ItemStack(WITHER_BONE));
                    ItemStack.add(new ItemStack(IceSnowBallItem));
                    ItemStack.add(new ItemStack(StoneNuggetSnowBallItem));
                    ItemStack.add(new ItemStack(BrickSnowBallItem));
                    ItemStack.add(new ItemStack(ObsidianSnowBallItem));
                    ItemStack.add(new ItemStack(EnderSnowBallItem));
                    ItemStack.add(new ItemStack(ExpSnowBallItem));
                    ItemStack.add(new ItemStack(HealthySnowBallItem));
                    ItemStack.add(new ItemStack(MilkSnowBallItem));
                    ItemStack.add(new ItemStack(PowderSnowBallItem));
                    ItemStack.add(new ItemStack(SpectralSnowBallItem));
                    ItemStack.add(new ItemStack(GlowInkSnowBallItem));
                    ItemStack.add(new ItemStack(GunpowderSnowBallItem));
                    ItemStack.add(new ItemStack(WitherSnowBallItem));
                    ItemStack.add(new ItemStack(SlimeSnowBallItem));
                    ItemStack.add(new ItemStack(DarknessSnowBallItem));
                    ItemStack.add(new ItemStack(AmethystSnowBallItem));
                }).build();
    }*/
    }
}
