package net.tb11.LostHorizons.blocks;

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

public abstract class AbstractCrystalSand extends BlockWithEntity {
    public Block crystalType;
    public AbstractCrystalSand(Settings settings, Block crystal) {
        super(settings);

        crystalType = crystal;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrystallineSandBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, LostHorizons.CRYSTAL_SAND_BLOCK_ENTITY, (world1, pos, state1, be) -> CrystallineSandBlockEntity.tick(world1, pos, state1, be));
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    public Block getCrystalType() {
        return crystalType;
    }
}
