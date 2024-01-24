package net.tb11.LostHorizons.block_entity_models;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;

public class TralyxConductorBlockEntityModel implements BlockEntityRenderer<TralyxConductorBlockEntity> {
    private static ItemStack crystal = new ItemStack(Items.AMETHYST_SHARD, 1);
    public TralyxConductorBlockEntityModel(BlockEntityRendererFactory.Context ctx){
    }
    @Override
    public void render(TralyxConductorBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((entity.getWorld().getTime() + tickDelta)*4.0f));
        MinecraftClient.getInstance().getItemRenderer().renderItem(crystal, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        matrices.pop();
    }
}
