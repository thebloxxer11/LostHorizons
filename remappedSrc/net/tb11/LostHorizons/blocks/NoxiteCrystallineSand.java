package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;
import net.tb11.LostHorizons.LostHorizons;

public class NoxiteCrystallineSand extends AbstractCrystalSand {
    public final MapCodec<NoxiteCrystallineSand> CODEC = NoxiteCrystallineSand.createCodec(settings -> new NoxiteCrystallineSand(settings));
    public NoxiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Noxite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
