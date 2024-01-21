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

public class NoxiteCrystallineSand extends AbstractCrystalSand { ;
    public final MapCodec<NoxiteCrystallineSand> CODEC = NoxiteCrystallineSand.createCodec(settings -> new NoxiteCrystallineSand((Settings)settings));
    public NoxiteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Noxite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
