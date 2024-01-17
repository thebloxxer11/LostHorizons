package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.block_entities.CrystallineSandBlockEntity;

public class CrylatiteCrystallineSand extends AbstractCrystalSand { ;
    public final MapCodec<CrylatiteCrystallineSand> CODEC = CrylatiteCrystallineSand.createCodec(settings -> new CrylatiteCrystallineSand((Settings)settings));
    public CrylatiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Crylatite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
