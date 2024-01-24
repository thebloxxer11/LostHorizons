package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class PyrotiteCrystallineSand extends AbstractCrystalSand {
    public final MapCodec<PyrotiteCrystallineSand> CODEC = PyrotiteCrystallineSand.createCodec(settings -> new PyrotiteCrystallineSand(settings));
    public PyrotiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Pyrotite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
