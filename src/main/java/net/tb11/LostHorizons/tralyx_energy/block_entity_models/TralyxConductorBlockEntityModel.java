package net.tb11.LostHorizons.tralyx_energy.block_entity_models;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;

public class TralyxConductorBlockEntityModel implements BlockEntityRenderer<TralyxConductorBlockEntity> {
    public TralyxConductorBlockEntityModel(BlockEntityRendererFactory.Context ctx){

    }
    @Override
    public void render(TralyxConductorBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
    }
}
