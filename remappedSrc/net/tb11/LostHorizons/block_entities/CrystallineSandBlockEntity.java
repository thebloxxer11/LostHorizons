package net.tb11.LostHorizons.block_entities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.blocks.AbstractCrystalSand;

public class CrystallineSandBlockEntity extends BlockEntity{
    private static final Integer RAND_INT = 16384;
    public CrystallineSandBlockEntity(BlockPos pos, BlockState state) {
        super(LostHorizons.CRYSTAL_SAND_BLOCK_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, CrystallineSandBlockEntity be){
        BlockPos blockAbovePos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        if (Random.create().nextInt(RAND_INT) == 0) {
            if (world.getBlockState(blockAbovePos).getBlock() == Blocks.AIR) {
                Block.replace(Blocks.AIR.getDefaultState(), ((AbstractCrystalSand) state.getBlock()).getCrystalType().getDefaultState(), world, blockAbovePos, 0);
            }
        }
    }
}
