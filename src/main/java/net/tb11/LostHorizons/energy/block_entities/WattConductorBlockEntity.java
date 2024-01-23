package net.tb11.LostHorizons.energy.block_entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.energy.WattConsumer;
import net.tb11.LostHorizons.energy.WattProvider;

public class WattConductorBlockEntity extends BlockEntity implements WattProvider, WattConsumer {
    public WattConductorBlockEntity(BlockPos pos, BlockState state) {
        super(LostHorizons.WATT_CONDUCTOR_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world1, BlockPos pos, BlockState state1, WattConductorBlockEntity be) {
    }
}
