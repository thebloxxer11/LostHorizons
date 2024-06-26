package net.tb11.LostHorizons.worldgen;

import net.minecraft.util.Identifier;
import net.tb11.LostHorizons.LostHorizons;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class LostHorizonsTerraBlender implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized()
    {
        // WorldGen code goes here.
        Regions.register(new ArcaniteBiomeRegion(new Identifier(LostHorizons.MOD_ID, "arcanite_caverns"), 2));
        Regions.register(new NullixBiomeRegion(new Identifier(LostHorizons.MOD_ID, "nullix_caverns"), 2));
        Regions.register(new PyrotiteBiomeRegion(new Identifier(LostHorizons.MOD_ID, "pyrotite_caverns"), 2));
        Regions.register(new CrylatiteBiomeRegion(new Identifier(LostHorizons.MOD_ID, "crylatite_caverns"), 2));
        Regions.register(new NoxiteBiomeRegion(new Identifier(LostHorizons.MOD_ID, "noxite_caverns"), 2));
        Regions.register(new ShoctiteBiomeRegion(new Identifier(LostHorizons.MOD_ID, "shoctite_caverns"), 2));
    }
}
