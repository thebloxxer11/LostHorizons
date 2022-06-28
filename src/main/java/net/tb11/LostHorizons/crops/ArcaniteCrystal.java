package net.tb11.LostHorizons.crops;


//import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
//import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.tb11.LostHorizons.LostHorizons;


public class ArcaniteCrystal extends CropBlock{
    private static final VoxelShape[] Growth_Stage = new VoxelShape[] {
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 28.0D, 16.0D)
    };
    
    public ArcaniteCrystal(AbstractBlock.Settings settings){
        super(settings);
        
    }

    public ItemConvertible getSeedsItem() {
        return LostHorizons.Arcanite_Seed;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Growth_Stage[(Integer)state.get(this.getAgeProperty())];
    }

    // @Override
    // public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
    //     BlockPos blockAbovePos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
    //     if ((world.getBlockState(blockAbovePos).getBlock() == Blocks.AIR)&&((Integer)state.get(this.getAgeProperty())<=(Integer)6)){
    //         this.applyGrowth(world, pos, state);
    //     }
    // }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos){
        return floor.isOf(LostHorizons.Arcanite_Sand);
    }
    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient){
        return false;
    }
}