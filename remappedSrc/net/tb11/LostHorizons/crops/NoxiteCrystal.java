package net.tb11.LostHorizons.crops;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.tb11.LostHorizons.LostHorizons;


public class NoxiteCrystal extends CropBlock{
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
    
    public NoxiteCrystal(AbstractBlock.Settings settings){
        super(settings);
        
    }

    public ItemConvertible getSeedsItem() {
        return LostHorizons.Noxite_Seed;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Growth_Stage[(Integer)state.get(this.getAgeProperty())];
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos){
        return floor.isOf(LostHorizons.Noxite_Sand);
    }
    // @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient){
        return false;
    }
}