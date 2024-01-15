package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.block_entities.CrystallineSandBlockEntity;

public class CrystallineSand extends BlockWithEntity {
    private static Block crystal;
    public static final MapCodec<CrystallineSand> CODEC = CrystallineSand.createCodec(settings -> new CrystallineSand((AbstractBlock.Settings)settings, (Block)crystal));

    public CrystallineSand(AbstractBlock.Settings settings, Block crystal) {
        super(settings);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, LostHorizons.CRYSTAL_SAND_BLOCK_ENTITY, (world1, pos, state1, be) -> CrystallineSandBlockEntity.tick(world1, pos, state1, be));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrystallineSandBlockEntity(pos, state);
    }

    public Block getCrystalType(){
        return crystal;
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
