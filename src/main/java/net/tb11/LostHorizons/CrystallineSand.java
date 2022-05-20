package net.tb11.LostHorizons;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class CrystallineSand extends Block{
    Block crystalType;
    public CrystallineSand(Settings settings, Block crystal){
        super(settings);
        crystalType = crystal;
    }
    
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        BlockPos blockAbovePos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if (world.getBlockState(blockAbovePos).getBlock() == Blocks.AIR) {
            if (random.nextInt(24) == 0) {
                Block.replace(Blocks.AIR.getDefaultState(), this.crystalType.getDefaultState(), world, blockAbovePos, 0);
             }
            }
    }
}
