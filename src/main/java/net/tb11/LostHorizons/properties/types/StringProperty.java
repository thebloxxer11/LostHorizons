// package net.tb11.LostHorizons.properties.types;

// import java.util.Collection;
// import java.util.HashSet;
// import java.util.Optional;

// import com.google.common.collect.ImmutableSet;
// import com.google.common.collect.Sets;

// import net.minecraft.state.property.Property;

// public class StringProperty extends Property<String>{
//     private final ImmutableSet<String> values; 

// protected StringProperty(String name, String string) {
//     super(name, String.class);
//     HashSet<String> set = Sets.newHashSet();
//     set.add(string);
//     this.values = ImmutableSet.copyOf(set);
// }

// public static StringProperty of(String name, String string){
//     return new StringProperty(name, string);
// }

// @Override
// public String name(String string_) {
//     return string_;
// }

// @Override
// public Collection<String> getValues() {
//     return this.values;
// }

// @Override
// public Optional<String> parse(String name) {
//     String string = String.valueOf(name);
//     if (isEmpty(string)){
//         return Optional.empty();
//     }else{
//         return Optional.of(string);
//     }

// }

// private Boolean isEmpty(String text){
//     if (text == "") {
//         return true;
//     }else{
//         return false;
//     }
// }
// }
