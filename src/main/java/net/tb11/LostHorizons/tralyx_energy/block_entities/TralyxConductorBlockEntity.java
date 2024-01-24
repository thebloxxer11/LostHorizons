package net.tb11.LostHorizons.tralyx_energy.block_entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.tralyx_energy.TralyxConsumer;
import net.tb11.LostHorizons.tralyx_energy.TralyxProvider;

public class TralyxConductorBlockEntity extends BlockEntity implements TralyxProvider, TralyxConsumer {
    public TralyxConductorBlockEntity(BlockPos pos, BlockState state) {
        super(LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world1, BlockPos pos, BlockState state1, TralyxConductorBlockEntity be) {

    }

}
