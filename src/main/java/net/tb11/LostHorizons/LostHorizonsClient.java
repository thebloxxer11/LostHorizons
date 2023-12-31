package net.tb11.LostHorizons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class LostHorizonsClient implements ClientModInitializer {
    // TODO: This code is giving me hell, compile failure
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Arcanite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Nullix_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Pyrotite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Crylatite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Noxite_Crystal);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Shoctite_Crystal);
    }
    
}
