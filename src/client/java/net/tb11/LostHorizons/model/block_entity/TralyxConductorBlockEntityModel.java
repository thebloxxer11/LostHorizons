package net.tb11.LostHorizons.model.block_entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;

import java.util.Objects;

public class TralyxConductorBlockEntityModel implements BlockEntityRenderer<TralyxConductorBlockEntity> {
    private static final ItemStack crystal = new ItemStack(Items.AMETHYST_SHARD, 1);
    public TralyxConductorBlockEntityModel(BlockEntityRendererFactory.Context ctx){}
    @Override
    public void render(TralyxConductorBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5f, 0.75f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((Objects.requireNonNull(entity.getWorld()).getTime() + tickDelta)*4.0f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45.0F));
        matrices.translate(0.125F,0.0F,0.0F);
        int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(entity.getWorld()), entity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(crystal, ModelTransformationMode.GROUND, lightAbove, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        matrices.pop();
    }
}
