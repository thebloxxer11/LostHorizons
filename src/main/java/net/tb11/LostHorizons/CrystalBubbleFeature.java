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
         for (int u = -1; u <= 1; u++){
             for (int v = -1; v <= 1; v++){
                 //Verify if Acting Chunk is loaded
                 if (!context.getWorld().isChunkLoaded(u+chunkOrigin.getCenterX(), v+chunkOrigin.getCenterZ())) {
                    //Stall generation until chunk is loaded
                    while (context.getWorld().isChunkLoaded(u+chunkOrigin.getCenterX(), v+chunkOrigin.getCenterZ())){
                        LostHorizons.LOGGER.info("Generation Stalled");
                    }
                 }
             }
         }
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
             int height = config.hMin().getMax() + context.getRandom().nextInt(config.hMax().getMax()-config.hMin().getMax()+1); //Height
             ellipsoidClear(context, config, chunkOriginCenter, rX, rZ, height);
             sandPlace(context, config, chunkOriginCenter, rX, rZ, rS);
             //ellipsePlaceXZ(context, config, new BlockPos(xChunk, yCast-1, zChunk), rX, rZ, rS, 2);
             //ellipsePlaceXZ(context, config, new BlockPos(xChunk, yCast-2, zChunk), rX, rZ, rS, 3);
             spikePlace(context, config, chunkOriginCenter, rX, rZ, rS, height);
         }else{
             LostHorizons.LOGGER.info("Placement Overriden by Chance");
         }
        
        return true;
    }

    private void sandPlace(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rZ, int rS){
        //Equation used: https://www.desmos.com/calculator/25luzkwexp
        int h = point.getX();
        int k = point.getZ();
        int l = point.getY();
        //int rSModified = rS/rSMod;
        for (int s = 3; s<=1; s++){
            for (int x = -rX; x < rX ;x++){
                for (int z = -rZ; z < rZ;z++){
                    for (int y = -2; y<=0; y++){
                        LostHorizons.LOGGER.info("Sand");
                        BlockPos actingPoint = new BlockPos(x, l, z);
                        if ((((x+h)^2)/((rS/s)*(rX^2)))+(((z-k)^2)/((rS/s)*(rZ^2)))+(y+l)/9<=1){
                            context.getWorld().setBlockState(actingPoint, config.blockSand().getBlockState(context.getRandom(), actingPoint), 3);
                        }
                    }
                }
            }   

        }
    }
    
    private void spikePlace(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rZ, int rS, int height){
        int h = point.getX();
        int k = point.getZ();
        int l = ((point.getY()-3)+point.getY()+height-3)/2;
        double s = 0.5;
        for (int x = -1; x < 2; x++){
            for (int z = -1; z < 2; z++){
                for (int y = -height/2; y<height; y++){
                    LostHorizons.LOGGER.info("Spike");
                    BlockPos actingPoint = new BlockPos(x, y, z);
                    if (((((x+h)^2)/s)+(((y+l)^2)/(height^2))+(((z+k)^2)/s))<=1){
                        context.getWorld().setBlockState(actingPoint, config.blockCrystal().getBlockState(context.getRandom(), actingPoint), 3);
                    }
                }
            }
        }
    }
    private void ellipsoidClear(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rZ, int height){
        int h = point.getX();
        int k = point.getZ();
        int l = ((point.getY()-3)+point.getY()+height-3)/2;

        for (int x = -rX; x < rX; x++){
            for (int z = -rZ; z<rZ; z++){
                for (int y = -height/2; y<height; y++){
                    LostHorizons.LOGGER.info("Clearing");
                    BlockPos actingPoint = new BlockPos(x, y, z);
                    if (((((x+h)^2)/(rX^2))+(((z+k)^2)/(rZ^2))+(((y+l)^2)/(height^2)))<=1){
                        context.getWorld().setBlockState(actingPoint, Blocks.AIR.getDefaultState(), 3);
                    }
                }
            }
        }
    }
}
