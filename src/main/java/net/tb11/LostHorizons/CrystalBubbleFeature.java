package net.tb11.LostHorizons;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
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
        BlockPos origin = context.getOrigin(); //Refers to the center of the 3rd layer from bottom
        ChunkPos chunkOrigin = context.getWorld().getChunk(origin).getPos(); //Obtains the chunk position in which it was cast in
        for (int u = -1; u <= 1; u++){
            for (int v = -1; v <= 1; v++){
                ChunkPos actingChunkPos = new ChunkPos(chunkOrigin.getCenterX()+16*u, chunkOrigin.getCenterZ()+16*v); //Acting Chunk Position
                //Verify if Acting Chunk is loaded
                //if 
            }
        }
        int xCast = origin.getX(); //Obtains the X value for where it was cast
        int yCast = origin.getY(); //Obtains the Y value for where it was cast
        int zCast = origin.getZ(); //Obtains the Z value for where it was cast
        
        if (context.getRandom().nextInt(config.chance().getMax()) == 0){
            int rX = config.rXMin().getMax() + context.getRandom().nextInt(config.rXMax().getMax()-config.rXMin().getMax()+1); //X-scaling
            int rZ = config.rZMin().getMax() + context.getRandom().nextInt(config.rZMax().getMax()-config.rZMin().getMax()+1); //Z-scaling
            int rS = 1 + context.getRandom().nextInt(2); //Scale Modifier
            int height = config.hMin().getMax() + context.getRandom().nextInt(config.hMax().getMax()-config.hMin().getMax()+1); //Height
            ellipsoidClear(context, config, origin, rX, rZ, height);
            ellipsePlaceXZ(context, config, origin, rX, rZ, rS, 1);
            ellipsePlaceXZ(context, config, new BlockPos(xCast, yCast-1, zCast), rX, rZ, rS, 1);
            ellipsePlaceXZ(context, config, new BlockPos(xCast, yCast-2, zCast), rX, rZ, rS, 1);
            spikePlace(context, config, origin, rX, rZ, rS, height);
        }else{
            LostHorizons.LOGGER.info("Placement Overriden by Chance");
        }

        return true;
    }

    private void ellipsePlaceXZ(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rY, int rS, int rSMod){
            //Equation used: https://www.desmos.com/calculator/25luzkwexp
            int h = point.getX();
            int k = point.getZ();
            int yOrigin = point.getY();
            int rSModified = rS/rSMod;
            for (int x = -rX; x < rX ;x++){
                for (int y = -rY; y < rY ;y++){
                    LostHorizons.LOGGER.info("Sand");
                    BlockPos actingPoint = new BlockPos(x, yOrigin, y);
                    if ((((x+h)^2)/(rSModified*(rX^2)))+(((y-k)^2)/(rSModified*(rY^2)))<=1){
                        context.getWorld().setBlockState(actingPoint, config.blockSand().getBlockState(context.getRandom(), actingPoint), 3);
                    }
                }
            }
    }
    private void spikePlace(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rY, int rS, int height){
        int h = point.getX();
        int k = point.getZ();
        int l = ((point.getY()-3)+point.getY()+height-3)/2;

        for (int x = -rX; x < rX; x++){
            for (int y = -rY; y<rY; y++){
                for (int z = -height/2; z<height; z++){
                    LostHorizons.LOGGER.info("Spike");
                    BlockPos actingPoint = new BlockPos(x, y, z);
                    if (((((x+h)^2)/1)+(((y+k)^2)/1)+(((z+l)^2)/(height^2)))<=1){
                        context.getWorld().setBlockState(actingPoint, config.blockCrystal().getBlockState(context.getRandom(), actingPoint), 3);
                    }
                }
            }
        }
    }
    private void ellipsoidClear(FeatureContext<CrystalBubbleFeatureConfig> context, CrystalBubbleFeatureConfig config, BlockPos point, int rX, int rY, int height){
        int h = point.getX();
        int k = point.getZ();
        int l = ((point.getY()-3)+point.getY()+height-3)/2;

        for (int x = -rX; x < rX; x++){
            for (int y = -rY; y<rY; y++){
                for (int z = -height/2; z<height; z++){
                    LostHorizons.LOGGER.info("Clearing");
                    BlockPos actingPoint = new BlockPos(x, y, z);
                    if (((((x+h)^2)/(rX^2))+(((y+k)^2)/(rY^2))+(((z+l)^2)/(height^2)))<=1){
                        context.getWorld().setBlockState(actingPoint, Blocks.AIR.getDefaultState(), 3);
                    }
                }
            }
        }
    }
}
