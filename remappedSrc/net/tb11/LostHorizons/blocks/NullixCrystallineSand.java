package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class NullixCrystallineSand extends AbstractCrystalSand {
    public static final MapCodec<NullixCrystallineSand> CODEC = NullixCrystallineSand.createCodec(settings -> new NullixCrystallineSand(settings));
    public NullixCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Nullix_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
