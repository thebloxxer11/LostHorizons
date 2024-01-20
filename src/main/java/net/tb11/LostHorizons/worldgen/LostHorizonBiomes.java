package net.tb11.LostHorizons.worldgen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.tb11.LostHorizons.LostHorizons;

public class LostHorizonBiomes {
    public static final RegistryKey<Biome> ARCANITE_CAVERNS = register("arcanite_caverns");

    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(LostHorizons.MOD_ID, name));
    }
}
