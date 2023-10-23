// package net.tb11.LostHorizons.worldgen.feature;

// import com.mojang.serialization.Codec;
// import com.mojang.serialization.codecs.RecordCodecBuilder;

// import net.minecraft.util.math.intprovider.IntProvider;
// import net.minecraft.world.gen.feature.FeatureConfig;
// import net.minecraft.world.gen.stateprovider.BlockStateProvider;
// import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

// public record CrystalSpikeFeatureConfig(IntProvider height, IntProvider radius, IntProvider angle,  BlockStateProvider state_provider) implements FeatureConfig{
//     public static final Codec<CrystalSpikeFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
//         IntProvider.VALUE_CODEC.fieldOf("height").forGetter(CrystalSpikeFeatureConfig::height),
//         IntProvider.VALUE_CODEC.fieldOf("radius").forGetter(CrystalSpikeFeatureConfig::radius),
//         IntProvider.VALUE_CODEC.fieldOf("angle").forGetter(CrystalSpikeFeatureConfig::angle), // Number between 1 and -1. 0 is linear, 1 is Quadratic, -1 is Rational
//         SimpleBlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter(CrystalSpikeFeatureConfig::state_provider)
//       ).apply(instance, instance.stable(CrystalSpikeFeatureConfig::new)));
// }
