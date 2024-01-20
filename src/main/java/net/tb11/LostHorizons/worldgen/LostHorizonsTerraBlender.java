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
        Regions.register(new CaveBiomeRegion(new Identifier(LostHorizons.MOD_ID, "overworld_1"), 2));
    }
}
