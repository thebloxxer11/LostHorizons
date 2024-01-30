package net.tb11.LostHorizons.tralyx_energy.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;

public class TralyxConductor extends BlockWithEntity{
    public static final MapCodec<TralyxConductor> CODEC = TralyxConductor.createCodec(TralyxConductor::new);
    public TralyxConductor(Settings settings) {
        super(settings);
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TralyxConductorBlockEntity(pos, state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, (world1, pos, state1, be) -> TralyxConductorBlockEntity.tick(world1, pos, state1, be));
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);
    }
}
