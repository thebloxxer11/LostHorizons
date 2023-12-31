package net.tb11.LostHorizons.block_properties;

import java.util.Collection;
import java.util.Optional;

import com.google.common.collect.ImmutableSet;

import net.minecraft.state.property.Property;

public class StringProperty extends Property<String>{
    private final ImmutableSet<String> values; 

protected StringProperty(String name) {
    super(name, String.class);
}

@Override
public String name(String string_) {
    return string_;
}

@Override
public Collection<String> getValues() {
    return this.values;
}

@Override
public Optional<String> parse(String name) {
    if isEmpty(String.valueOf(name))
}

private Boolean isEmpty(String text){
    if (text == "") {
        return true;
    }else{
        return false;
    }
}
}
