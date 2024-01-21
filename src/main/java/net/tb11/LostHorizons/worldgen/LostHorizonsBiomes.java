package net.tb11.LostHorizons.worldgen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.tb11.LostHorizons.LostHorizons;

public class LostHorizonsBiomes {
    public static final RegistryKey<Biome> ARCANITE_CAVERNS = register("arcanite_caverns");
    public static final RegistryKey<Biome> NULLIX_CAVERNS = register("nullix_caverns");
    public static final RegistryKey<Biome> PYROTITE_CAVERNS = register("pyrotite_caverns");
    public static final RegistryKey<Biome> CRYLATITE_CAVERNS = register("crylatite_caverns");
    public static final RegistryKey<Biome> NOXITE_CAVERNS = register("noxite_caverns");
    public static final RegistryKey<Biome> SHOCTITE_CAVERNS = register("shoctite_caverns");

    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(LostHorizons.MOD_ID, name));
    }
}
