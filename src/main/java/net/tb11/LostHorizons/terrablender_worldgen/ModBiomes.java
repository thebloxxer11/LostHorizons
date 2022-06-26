package net.tb11.LostHorizons.terrablender_worldgen;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static void registerBiomes()
    {
        
    }

    private static void register(Identifier key, Biome biome)
    {
        Registry.register(BuiltinRegistries.BIOME, key, biome);
    } 
}
