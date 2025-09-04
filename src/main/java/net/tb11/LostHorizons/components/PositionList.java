package net.tb11.LostHorizons.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public record PositionList(List<Position> posList) {
    public static final Codec<PositionList> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(Codec.PASSTHROUGH.fieldOf("max").forGetter(PositionList::posList)
                ).apply(builder, PositionList::new);
    });
}
