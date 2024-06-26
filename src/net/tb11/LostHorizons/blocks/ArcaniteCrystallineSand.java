package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;

import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class ArcaniteCrystallineSand extends AbstractCrystalSand {
    public static final MapCodec<ArcaniteCrystallineSand> CODEC = ArcaniteCrystallineSand.createCodec(settings -> new ArcaniteCrystallineSand(settings));
    public ArcaniteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Arcanite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
