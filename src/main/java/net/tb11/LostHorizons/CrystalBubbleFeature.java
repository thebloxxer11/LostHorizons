package net.tb11.LostHorizons;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;





//Note: Uses Applied Mathematics to a large degree
public class CrystalBubbleFeature extends Feature<CrystalBubbleFeatureConfig>{
    public CrystalBubbleFeature(Codec<CrystalBubbleFeatureConfig> configCodec){
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<CrystalBubbleFeatureConfig> context){
        CrystalBubbleFeatureConfig config = context.getConfig();
        BlockPos blockOrigin = context.getOrigin(); //Refers to the center of the 3rd layer from bottom
        ChunkPos chunkOrigin = context.getWorld().getChunk(blockOrigin).getPos(); //Obtains the chunk position in which it was cast in
        //  for (int u = -1; u <= 1; u++){
        //      for (int v = -1; v <= 1; v++){
        //          //Verify if Acting Chunk is loaded
        //          if (!context.getWorld().isChunkLoaded(u+chunkOrigin.getCenterX(), v+chunkOrigin.getCenterZ())) {
        //             //Stall generation until chunk is loaded
        //             while (context.getWorld().isChunkLoaded(u+chunkOrigin.getCenterX(), v+chunkOrigin.getCenterZ())){
        //                 LostHorizons.LOGGER.info("Generation Stalled");
        //             }
        //          }
        //      }
        //  }
         int xCast = blockOrigin.getX(); //Obtains the X value for where it was cast
         int yCast = blockOrigin.getY(); //Obtains the Y value for where it was cast
         int zCast = blockOrigin.getZ(); //Obtains the Z value for where it was cast
         int xChunk = chunkOrigin.getCenterX();
         int zChunk = chunkOrigin.getCenterZ();
         BlockPos chunkOriginCenter = new BlockPos(xChunk, yCast, zChunk); //Get the center of the chunk - where the feature will be placed

         if (context.getRandom().nextInt(config.chance().getMax()) == 0){
             int rX = config.rXMin().getMax() + context.getRandom().nextInt(config.rXMax().getMax()-config.rXMin().getMax()+1); //X-scaling
             int rZ = config.rZMin().getMax() + context.getRandom().nextInt(config.rZMax().getMax()-config.rZMin().getMax()+1); //Z-scaling
             int rS = 1 + context.getRandom().nextInt(2); //Scale Modifier
             double height = config.hMin().getMax() + context.getRandom().nextInt(config.hMax().getMax()-config.hMin().getMax()+1); //Height
             ellipsoidClear(context, config, chunkOriginCenter, rX, rZ, height);
             sandPlace(context, config, chunkOriginCenter, rX, rZ, rS);
             //ellipsePlaceXZ(context, config, new BlockPos(xChunk, yCast-1, zChunk), rX, rZ, rS, 2);
             //ellipsePlaceXZ(context, config, new BlockPos(xChunk, yCast-2, zChunk), rX, rZ, rS, 3);
             spikePlace(context, config, chunkOriginCenter, height);
             LostHorizons.LOGGER.info(chunkOriginCenter.toString());
         }else{
             LostHorizons.LOGGER.info("Placement Overriden by Chance");
         }
        
        return true;
    }

    private void sandPlace(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, double rX, double rZ, double rS){
        //Equation used: https://www.desmos.com/calculator/25luzkwexp
        double h = point.getX();
        double k = point.getZ();
        double l = point.getY();

        for (double s = 3; s<=1; s--){
            for (Double x = -1.0D*rX; x <= rX; x++){
                for (Double z = -1.0D*rZ; z <= rZ;z++){
                    for (Double y = -2.0D; y<=0; y++){
                        //LostHorizons.LOGGER.info("Sand");
                        BlockPos actingPoint = new BlockPos(x, s, z);
                        if ((Math.pow((x+h), 2.0D)/((rS/s)*Math.pow(rX, 2.0D)))+(Math.pow((z-k), 2.0D)/((rS/s)*Math.pow(rZ, 2.0D)))+Math.pow((y+l), 2.0D)/9<=1){
                            context.getWorld().setBlockState(actingPoint, config.blockSand().getBlockState(context.getRandom(), actingPoint), 3);
                        }
                    }
                }
            }   

        }
    }
    
    private void spikePlace(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, double height){
        double h = point.getX();
        double k = point.getZ();
        double l = ((point.getY()-3)+point.getY()+height-3)/2;
        double s = 0.5;

        for (Double x = -1.0D; x <= 2; x++){
            for (Double z = -1.0D; z <= 2; z++){
                for (Double y = -1.0D*height; y<height; y++){
                    //LostHorizons.LOGGER.info("Spike");
                    BlockPos actingPoint = new BlockPos(x.intValue(), y.intValue(), z.intValue());
                    if (((Math.pow((x+h), 2.0D)/s)+(Math.pow((y+l), 2.0D)/Math.pow(height, 2.0D))+(Math.pow((z+k), 2.0D)/s))<=1){
                        context.getWorld().setBlockState(actingPoint, config.blockCrystal().getBlockState(context.getRandom(), actingPoint), 3);
                    }
                }
            }
        }
    }

    private void ellipsoidClear(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, double rX, double rZ, double height){
        double h = point.getX();
        double k = point.getZ();
        double l = ((point.getY()-3)+point.getY()+height-3)/2;

        for (Double x = -rX; x <= rX; x++){
            for (Double z = -rZ; z <= rZ; z++){
                for (Double y = -1.0D*height; y <= height; y++){
                    //LostHorizons.LOGGER.info("Clearing");
                    BlockPos actingPoint = new BlockPos(x.intValue(), y.intValue(), z.intValue());
                    if (((Math.pow((x+h), 2.0D)/Math.pow(rX, 2.0D))+(Math.pow((z+k), 2.0D)/Math.pow(rZ, 2.0D))+(Math.pow((y+l), 2.0D)/Math.pow(height, 2.0D)))<=1){
                        context.getWorld().setBlockState(actingPoint, Blocks.AIR.getDefaultState(), 3);
                    }
                }
            }
        }
    }
}
