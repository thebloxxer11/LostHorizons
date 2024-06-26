package net.tb11.LostHorizons.worldgen;


import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class NullixBiomeRegion extends Region {

    public NullixBiomeRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        MultiNoiseUtil.NoiseHypercube noiseHypercube = new MultiNoiseUtil.NoiseHypercube(
                ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.COOL),
                ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID),
                ParameterUtils.Continentalness.INLAND.parameter(),
                ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1),
                ParameterUtils.Depth.span(ParameterUtils.Depth.UNDERGROUND, ParameterUtils.Depth.FLOOR),
                ParameterUtils.Weirdness.span(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING),
                0L
                );
        builder.add(noiseHypercube, LostHorizonsBiomes.NULLIX_CAVERNS);
        builder.build().forEach(mapper);
    }
}
