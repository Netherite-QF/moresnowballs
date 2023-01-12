package com.maomao.more_snowballs.client;

import com.maomao.more_snowballs.MoreSnowballs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class MoreSnowballsClient implements ClientModInitializer {
    public MoreSnowballsClient() {
    }

    public void onInitializeClient() {
        EntityRendererRegistry.register(MoreSnowballs.ICE_SNOWBALLS_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.SLIME_SNOW_BALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.SPECTRAL_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.WITHER_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.AMETHYST_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.POWDER_SNOW_BALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.STONE_NUGGET_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.GUNPOWDER_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.GLOW_INK_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.BRICK_SNOWBALL_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.OBSIDIAN_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.ENDER_SNOWBALL_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.MILK_SNOWBALL_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.HEALTHY_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.EXP_SNOWBALL_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MoreSnowballs.DARKNESS_SNOWBALL_ENTITY_ENTITY_TYPE,
                FlyingItemEntityRenderer::new);
    }
}
