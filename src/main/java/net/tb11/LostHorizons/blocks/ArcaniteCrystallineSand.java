package net.tb11.LostHorizons.blocks;


import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractBlock;
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
import net.tb11.LostHorizons.crops.ArcaniteCrystal;

public class ArcaniteCrystallineSand extends AbstractCrystalSand { ;
    public static final MapCodec<ArcaniteCrystallineSand> CODEC = ArcaniteCrystallineSand.createCodec(settings -> new ArcaniteCrystallineSand((AbstractBlock.Settings)settings));
    public ArcaniteCrystallineSand(Settings settings) {
        super(settings, LostHorizons.Arcanite_Crystal);
    }
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
