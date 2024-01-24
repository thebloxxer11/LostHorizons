 package net.tb11.LostHorizons;

 import net.fabricmc.api.ClientModInitializer;
 import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
 import net.minecraft.client.render.RenderLayer;
 import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
 import net.tb11.LostHorizons.block_entity_models.TralyxConductorBlockEntityModel;

 public class LostHorizonsClient implements ClientModInitializer {

     @Override
     public void onInitializeClient() {
         //CropBlock Transparency
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Arcanite_Crystal);
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Nullix_Crystal);
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Pyrotite_Crystal);
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Crylatite_Crystal);
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Noxite_Crystal);
         BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), LostHorizons.Shoctite_Crystal);

         BlockEntityRendererFactories.register(LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, TralyxConductorBlockEntityModel::new);
         LostHorizons.LOGGER.info("Clientside Loaded");
     }

 }
