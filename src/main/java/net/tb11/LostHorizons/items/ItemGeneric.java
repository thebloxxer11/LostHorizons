package net.tb11.LostHorizons.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tb11.LostHorizons.LostHorizons;

public class ItemGeneric {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(LostHorizons.MOD_ID, id);


        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {

    }
}
