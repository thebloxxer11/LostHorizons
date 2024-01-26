package net.tb11.LostHorizons.tralyx_energy.block_entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.tralyx_energy.TralyxConsumer;
import net.tb11.LostHorizons.tralyx_energy.TralyxProvider;
import org.jetbrains.annotations.Nullable;

public class TralyxConductorBlockEntity extends BlockEntity implements TralyxProvider, TralyxConsumer {
    public TralyxConductorBlockEntity(BlockPos pos, BlockState state) {
        super(LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, pos, state);
    }
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save to NBT

        super.writeNbt(nbt);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        //Load from NBT
    }
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
    public static void tick(World world1, BlockPos pos, BlockState state1, TralyxConductorBlockEntity be) {

    }

}
