package net.tb11.LostHorizons.worldgen.feature;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.tb11.LostHorizons.LostHorizons;


public class CrystalSpikeFeature extends Feature<CrystalSpikeFeatureConfig>{
    public CrystalSpikeFeature(Codec<CrystalSpikeFeatureConfig> configCodec){
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<CrystalSpikeFeatureConfig> context){
        CrystalSpikeFeatureConfig config = context.getConfig();
        
        return true;
    }
}
