package net.tb11.LostHorizons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.tb11.LostHorizons.block_entities.CrystallineSandBlockEntity;
import net.tb11.LostHorizons.blocks.*;
import net.tb11.LostHorizons.crops.*;
import net.tb11.LostHorizons.item_groups.ItemGroupGeneric;
import net.tb11.LostHorizons.items.*;
import net.tb11.LostHorizons.items.tools.EngineersGauntlet;
import net.tb11.LostHorizons.tralyx_energy.block_entities.TralyxConductorBlockEntity;
import net.tb11.LostHorizons.tralyx_energy.blocks.TralyxConductor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostHorizons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("losthorizons");
	public static final String MOD_ID = "losthorizons";
	//Group Registries
	//Materials
	public static final ItemGroup LHMATR_GROUP = ItemGroupGeneric.register(FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("itemGroup.losthorizons.materials")).build(), "materials_group");
	//Machines and Constructs
	public static final ItemGroup LHMACH_GROUP = ItemGroupGeneric.register(FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("itemGroup.losthorizons.machines")).build(), "machines_group");
	//Tools, Armor and Weaponry
	public static final ItemGroup LHTOOL_GROUP = ItemGroupGeneric.register(FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("itemGroup.losthorizons.tools")).build(), "tools_group");

	//Blocks
	//Standard Case - Ores
	public static final Block Tin_Ore = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)), "tin_ore", true); //Tin Ore
	public static final Block Tin_Ore_Deep = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), "tin_ore_deep", true); //Deepslate Tin Ore
	public static final Block Hexatium_Ore = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), "hexatium_ore", true); //Hexatium Ore
	public static final Block Lithium_Ore = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)), "lithium_ore", true); //Lithium Ore
	public static final Block Lithium_Ore_Deep = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), "lithium_ore_deep", true); //Deepslate Lithium Ore
	public static final Block Aluminum_Ore = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)), "aluminum_ore", true); //Laterite Ore
	public static final Block Galena_Ore = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)), "galena_ore", true); //Galena Ore
	//Standard Case - Material Blocks
	public static final Block Tin_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "tin_block", true);
	public static final Block Lithium_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "lithium_block", true);
	public static final Block Aluminum_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "aluminum_block", true);
	public static final Block Lead_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "lead_block", true);
	public static final Block Silver_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "silver_block", true);
	public static final Block Hexatium_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)), "hexatium_block", true);
	//Standard Case - Crystal Blocks
	public static final Block Arcanite_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "arcanite_block", true);
	public static final Block Nullix_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "nullix_block", true);
	public static final Block Pyrotite_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "pyrotite_block", true);
	public static final Block Crylatite_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "crylatite_block", true);
	public static final Block Noxite_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "noxite_block", true);
	public static final Block Shoctite_Block = BlockGeneric.register(new Block(AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)), "shoctite_block", true);
	//Crystals
	public static final Block Arcanite_Crystal = BlockGeneric.register(new ArcaniteCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "arcanite_crystal", true);
	public static final Block Nullix_Crystal = BlockGeneric.register(new NullixCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "nullix_crystal", true);
	public static final Block Pyrotite_Crystal = BlockGeneric.register(new PyrotiteCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "pyrotite_crystal", true);
	public static final Block Crylatite_Crystal = BlockGeneric.register(new CrylatiteCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "crylatite_crystal", true);
	public static final Block Noxite_Crystal = BlockGeneric.register(new NoxiteCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "noxite_crystal", true);
	public static final Block Shoctite_Crystal = BlockGeneric.register(new ShoctiteCrystal(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)), "shoctite_crystal", true);
	//Crystalline Sand
	public static final Block Arcanite_Sand = BlockGeneric.register(new ArcaniteCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "arcanite_sand", true);
	public static final Block Nullix_Sand = BlockGeneric.register(new NullixCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "nullix_sand", true);
	public static final Block Pyrotite_Sand = BlockGeneric.register(new PyrotiteCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "pyrotite_sand", true);
	public static final Block Crylatite_Sand = BlockGeneric.register(new CrylatiteCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "crylatite_sand", true);
	public static final Block Noxite_Sand = BlockGeneric.register(new NoxiteCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "noxite_sand", true);
	public static final Block Shoctite_Sand = BlockGeneric.register(new ShoctiteCrystallineSand(AbstractBlock.Settings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND)), "shoctite_sand", true);
	//Functional Blocks
	//Power Network
	public static final Block Tralyx_Conductor = BlockGeneric.register(new TralyxConductor(AbstractBlock.Settings.create().nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).luminance(state->(7)).hardness(4.5f).requiresTool().sounds(BlockSoundGroup.METAL)), "tralyx_conductor", true);

    //Items
	//Materials - Raw
	public static final Item Tin_Raw =      ItemGeneric.register(new Item(new Item.Settings()), "tin_raw"); //Tin Ore Item
	public static final Item Tin_Ref =      ItemGeneric.register(new Item(new Item.Settings()), "tin_ingot"); //Tin Ingot
	public static final Item Lithium_Raw =  ItemGeneric.register(new Item(new Item.Settings()), "lithium_raw"); //Lithium Ore Item
	public static final Item Lithium_Ref =  ItemGeneric.register(new Item(new Item.Settings()), "lithium_ingot"); //Lithium Ingot
	public static final Item Aluminum_Raw = ItemGeneric.register(new Item(new Item.Settings()), "aluminum_raw"); //Laterite (Aluminum Ore) Item
	public static final Item Aluminum_Ref = ItemGeneric.register(new Item(new Item.Settings()), "aluminum_ingot"); //Aluminum Ingot
	public static final Item Hexatium_Raw = ItemGeneric.register(new Item(new Item.Settings()), "hexatium_raw"); //Hexatium Ore Item
	public static final Item Hexatium_Ref = ItemGeneric.register(new Item(new Item.Settings()), "hexatium_ingot"); //Hexatium Ingot
	public static final Item Rubber_Raw =   ItemGeneric.register(new Item(new Item.Settings()), "rubber_raw"); //Raw Rubber
	public static final Item Rubber =       ItemGeneric.register(new Item(new Item.Settings()), "rubber"); //Standard Rubber
	public static final Item Rubber_Ref =   ItemGeneric.register(new Item(new Item.Settings()), "rubber_vulcanized"); //Vulcanized Rubber
	public static final Item Galena_Raw =   ItemGeneric.register(new Item(new Item.Settings()), "galena_raw"); //Galena Ore Item
	public static final Item Lead_Ref =     ItemGeneric.register(new Item(new Item.Settings()), "lead_ingot"); //Lead Ingot
	public static final Item Silver_Ref =   ItemGeneric.register(new Item(new Item.Settings()), "silver_ingot"); //Silver Ingot
	public static final Item Sulfur =       ItemGeneric.register(new Item(new Item.Settings()), "sulfur"); //Lead Refinement Byproduct, Sulfur
	public static final Item Steel_Ingot =  ItemGeneric.register(new Item(new Item.Settings()), "steel_ingot"); //Steel Ingot
	//Materials - Arcane Crystal Shard
	public static final Item Arcanite_Shard =   ItemGeneric.register(new Item(new Item.Settings()), "arcanite"); //Arcanite Crystal - Arcane - Manipulates Arcana
	public static final Item Pyrotite_Shard =   ItemGeneric.register(new Item(new Item.Settings()), "pyrotite"); //Pyrotite Crystal - Heat - burns entities
	public static final Item Crylatite_Shard =  ItemGeneric.register(new Item(new Item.Settings()), "crylatite"); //Crylatite Crystal - Cold - slows entities
	public static final Item Noxite_Shard =     ItemGeneric.register(new Item(new Item.Settings()), "noxite"); //Noxite Crystal - Life - poisons entities
	public static final Item Shoctite_Shard =   ItemGeneric.register(new Item(new Item.Settings()), "shoctite"); //Shoctite Crystal - Lightning - stuns entities
	public static final Item Nullix_Shard =     ItemGeneric.register(new Item(new Item.Settings()), "nullix"); //Nullix Crystal - Void - Manipulates the Void
	//Crystal "Seeds"
	public static final Item Arcanite_Seed = new AliasedBlockItem(Arcanite_Crystal, new Item.Settings());
	public static final Item Nullix_Seed = new AliasedBlockItem(Nullix_Crystal, new Item.Settings());
	public static final Item Pyrotite_Seed = new AliasedBlockItem(Pyrotite_Crystal, new Item.Settings());
	public static final Item Crylatite_Seed = new AliasedBlockItem(Crylatite_Crystal, new Item.Settings());
	public static final Item Noxite_Seed = new AliasedBlockItem(Noxite_Crystal, new Item.Settings());
	public static final Item Shoctite_Seed = new AliasedBlockItem(Shoctite_Crystal, new Item.Settings());
	public static final Item Engineers_Gauntlet = ItemGeneric.register(new EngineersGauntlet(new Item.Settings().maxCount(1)), "engineers_gauntlet");

    //Block Entities
	public static final BlockEntityType<CrystallineSandBlockEntity> CRYSTAL_SAND_BLOCK_ENTITY = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of("losthorizons", "crystal_sand_block_entity"),
        BlockEntityType.Builder.create(CrystallineSandBlockEntity::new, Arcanite_Sand, Nullix_Sand, Pyrotite_Sand, Crylatite_Sand, Noxite_Sand, Shoctite_Sand).build()
    );
	public static final BlockEntityType<TralyxConductorBlockEntity> TRALYX_CONDUCTOR_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			Identifier.of("losthorizons", "tralyx_conductor_block_entity"),
            BlockEntityType.Builder.create(TralyxConductorBlockEntity::new, Tralyx_Conductor).build()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("LH Initialization Started");
        //Initialize Generic Items and Blocks
        ItemGroupGeneric.initialize();
        ItemGeneric.initialize();
        BlockGeneric.initialize();
		//Material Items
		 addToGroupInPost(Tin_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Tin_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lithium_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lithium_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Aluminum_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Aluminum_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Hexatium_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Hexatium_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Rubber_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Rubber, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Rubber_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Galena_Raw, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lead_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Silver_Ref, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Sulfur, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Steel_Ingot, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Arcanite_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Nullix_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Pyrotite_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Crylatite_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Noxite_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Shoctite_Shard, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Arcanite_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Nullix_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Pyrotite_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Crylatite_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Noxite_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Shoctite_Seed, Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 //Material Blocks
		 addToGroupInPost(Arcanite_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Nullix_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Pyrotite_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Crylatite_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Noxite_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Shoctite_Sand.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Arcanite_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Nullix_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Pyrotite_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Crylatite_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Noxite_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Shoctite_Crystal.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Arcanite_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Nullix_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Pyrotite_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Crylatite_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Noxite_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Shoctite_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Tin_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lithium_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lead_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Silver_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Aluminum_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Hexatium_Block.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Tin_Ore.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Tin_Ore_Deep.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lithium_Ore.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Lithium_Ore_Deep.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Hexatium_Ore.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Aluminum_Ore.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());
		 addToGroupInPost(Galena_Ore.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMATR_GROUP).getKey().get());

		 addToGroupInPost(Tralyx_Conductor.asItem(), Registries.ITEM_GROUP.getEntry(LostHorizons.LHMACH_GROUP).getKey().get());
         addToGroupInPost(Engineers_Gauntlet, Registries.ITEM_GROUP.getEntry(LostHorizons.LHTOOL_GROUP).getKey().get());

		 BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("losthorizons", "tin_ore")));
		 BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("losthorizons", "lithium_ore")));
		 BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("losthorizons", "aluminum_ore")));
		 BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("losthorizons", "galena_ore")));
		 BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("losthorizons", "hexatium_ore")));
		 LostHorizons.LOGGER.info("Serverside Loaded");
		}

	 public void addToGroupInPost(Item item, RegistryKey<ItemGroup> group){
	 	ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(item));
	 }
}
