package net.tb11.LostHorizons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.tb11.LostHorizons.model.block_entity.TralyxConductorBlockEntityModel;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;


public class LostHorizonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Arcanite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Nullix_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Pyrotite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Crylatite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Noxite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Shoctite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Tralyx_Conductor);
        BlockEntityRendererFactories.register(LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, TralyxConductorBlockEntityModel::new);
    }
    
}
