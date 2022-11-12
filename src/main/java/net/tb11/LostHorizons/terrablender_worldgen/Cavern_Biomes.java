package net.tb11.LostHorizons.terrablender_worldgen;

import javax.annotation.Nullable;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.math.MathHelper;

public class Cavern_Biomes {
    @Nullable
    private static final MusicSound SILENCE_MUSIC = null;
    @Nullable
    private static final BiomeMoodSound SILENCE_AMBIENCE = null;

    private static final EntityType[] mobCavernStdHostile = {EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER, EntityType.CREEPER};

    protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = MathHelper.clamp($$1, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, SpawnSettings.Builder spawnBuilder, GenerationSettings.Builder biomeBuilder, @Nullable MusicSound music, @Nullable BiomeMoodSound moodsound)
    {
        return biome(precipitation, category, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music, moodsound);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder spawnBuilder, GenerationSettings.Builder biomeBuilder, @Nullable MusicSound music, @Nullable BiomeMoodSound moodsound)
    {
        return (new Biome.Builder()).precipitation(precipitation).category(category).temperature(temperature).downfall(downfall).spawnSettings(spawnBuilder.build()).effects((new BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).music(music).moodSound(moodsound).build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalOverworldGeneration(GenerationSettings.Builder builder)
    {
        //Global Biome Features
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
        DefaultBiomeFeatures.addDefaultSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome cavernArcanite(){
        //Spawns
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //Standard Case
        for (EntityType hostile : mobCavernStdHostile){
            spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnEntry(hostile, 5, 1, 4));
        }
        //Zombie Villagers
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 2, 1, 1));
        //Bats
        spawnBuilder.spawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 5, 8, 8));


        //Biome Features
        GenerationSettings.Builder biomeBuilder = new GenerationSettings.Builder();

        return biome(Biome.Precipitation.NONE, Biome.Category.UNDERGROUND, 0.0F, 0.0F, spawnBuilder, biomeBuilder, SILENCE_MUSIC, SILENCE_AMBIENCE);
    }
}
