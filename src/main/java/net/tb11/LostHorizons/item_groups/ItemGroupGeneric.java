package net.tb11.LostHorizons.item_groups;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.tb11.LostHorizons.LostHorizons;

public class ItemGroupGeneric {
    public static ItemGroup register(ItemGroup itemGroup, String name){
        Identifier groupID = Identifier.of(LostHorizons.MOD_ID, name);
        return Registry.register(Registries.ITEM_GROUP, RegistryKey.of(Registries.ITEM_GROUP.getKey(), groupID), itemGroup);
    }

    public static void initialize(){

    }
}
