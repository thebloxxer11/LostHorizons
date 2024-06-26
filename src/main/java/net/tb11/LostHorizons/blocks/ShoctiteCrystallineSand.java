package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class ShoctiteCrystallineSand extends AbstractCrystalSand {
    public final MapCodec<ShoctiteCrystallineSand> CODEC = ShoctiteCrystallineSand.createCodec(settings -> new ShoctiteCrystallineSand(settings));
    public ShoctiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Shoctite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
