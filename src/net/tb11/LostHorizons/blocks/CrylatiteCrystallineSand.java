package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class CrylatiteCrystallineSand extends AbstractCrystalSand {
    public final MapCodec<CrylatiteCrystallineSand> CODEC = CrylatiteCrystallineSand.createCodec(settings -> new CrylatiteCrystallineSand(settings));
    public CrylatiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Crylatite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
