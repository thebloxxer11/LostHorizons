package net.tb11.LostHorizons.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record PositionArray(int max, ) {
    public static final Codec<PositionArray> CODEC = RecordCodecBuilder.create(builder -> {
    return builder.group(Codec.INT.fieldOf("max").forGetter(PositionArray::max), )
    });
}
