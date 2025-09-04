package net.tb11.LostHorizons.tralyx_energy.block_entities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.tb11.LostHorizons.LostHorizons;
import net.tb11.LostHorizons.tralyx_energy.TralyxConsumer;
import net.tb11.LostHorizons.tralyx_energy.TralyxProvider;
import org.jetbrains.annotations.Nullable;

//TODO: Replace NBT with Data Components

public class TralyxConductorBlockEntity extends BlockEntity implements TralyxProvider, TralyxConsumer {
    public BlockPos[] connections = new BlockPos[4];
    public TralyxConductorBlockEntity(BlockPos pos, BlockState state) {
        super(LostHorizons.TRALYX_CONDUCTOR_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world1, BlockPos pos, BlockState state1, TralyxConductorBlockEntity be) {

    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper){
        int[] con1Pos = {connections[0].getX(), connections[0].getY(), connections[0].getZ()};
        nbt.putIntArray("con1", con1Pos);
        int[] con2Pos = {connections[1].getX(), connections[1].getY(), connections[1].getZ()};
        nbt.putIntArray("con2", con2Pos);
        int[] con3Pos = {connections[2].getX(), connections[2].getY(), connections[2].getZ()};
        nbt.putIntArray("con3", con3Pos);
        int[] con4Pos = {connections[3].getX(), connections[3].getY(), connections[3].getZ()};
        nbt.putIntArray("con4", con4Pos);

        super.writeNbt(nbt, wrapper);

    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper){
        super.readNbt(nbt, wrapper);

        connections[0] = new BlockPos(new Vec3i(nbt.getIntArray("con1")[0], nbt.getIntArray("con1")[1], nbt.getIntArray("con1")[2]));
        connections[1] = new BlockPos(new Vec3i(nbt.getIntArray("con2")[0], nbt.getIntArray("con2")[1], nbt.getIntArray("con2")[2]));
        connections[2] = new BlockPos(new Vec3i(nbt.getIntArray("con3")[0], nbt.getIntArray("con3")[1], nbt.getIntArray("con3")[2]));
        connections[3] = new BlockPos(new Vec3i(nbt.getIntArray("con4")[0], nbt.getIntArray("con4")[1], nbt.getIntArray("con4")[2]));

    }
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup wrapper) {
        return createNbt(wrapper);
    }
}
