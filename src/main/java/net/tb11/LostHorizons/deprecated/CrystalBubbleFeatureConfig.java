package net.tb11.LostHorizons.deprecated;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public record CrystalBubbleFeatureConfig(IntProvider chance, IntProvider hMin, IntProvider hMax, IntProvider rXMin, IntProvider rXMax, IntProvider rZMin, IntProvider rZMax, BlockStateProvider blockSand, BlockStateProvider blockCrystal) implements FeatureConfig{
    public static final Codec<CrystalBubbleFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        IntProvider.VALUE_CODEC.fieldOf("chance").forGetter(CrystalBubbleFeatureConfig::chance),
        IntProvider.VALUE_CODEC.fieldOf("hMin").forGetter(CrystalBubbleFeatureConfig::hMin),
        IntProvider.VALUE_CODEC.fieldOf("hMax").forGetter(CrystalBubbleFeatureConfig::hMax),
        IntProvider.VALUE_CODEC.fieldOf("rXMin").forGetter(CrystalBubbleFeatureConfig::rXMin),
        IntProvider.VALUE_CODEC.fieldOf("rXMax").forGetter(CrystalBubbleFeatureConfig::rXMax),
        IntProvider.VALUE_CODEC.fieldOf("rZMin").forGetter(CrystalBubbleFeatureConfig::rZMin),
        IntProvider.VALUE_CODEC.fieldOf("rZMax").forGetter(CrystalBubbleFeatureConfig::rZMax),
        SimpleBlockStateProvider.TYPE_CODEC.fieldOf("blockSand").forGetter(CrystalBubbleFeatureConfig::blockSand),
        SimpleBlockStateProvider.TYPE_CODEC.fieldOf("blockCrystal").forGetter(CrystalBubbleFeatureConfig::blockCrystal)
      ).apply(instance, instance.stable(CrystalBubbleFeatureConfig::new)));
}
