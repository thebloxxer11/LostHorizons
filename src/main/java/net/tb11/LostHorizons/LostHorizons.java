package net.tb11.LostHorizons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.tb11.LostHorizons.blocks.CrystallineSand;
import net.tb11.LostHorizons.crops.ArcaniteCrystal;
import net.tb11.LostHorizons.crops.CrylatiteCrystal;
import net.tb11.LostHorizons.crops.NoxiteCrystal;
import net.tb11.LostHorizons.crops.NullixCrystal;
import net.tb11.LostHorizons.crops.PyrotiteCrystal;
import net.tb11.LostHorizons.crops.ShoctiteCrystal;

public class LostHorizons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	//Group Registries
	//Materials
	public static final ItemGroup LHMAT_GROUP = FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("lh_materials")).build();
	//Hybrid
	public static final ItemGroup LHHYB_GROUP = FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("lh_hybrid")).build();
	//Techna
	public static final ItemGroup LHTEC_GROUP = FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("lh_techna")).build();
	//Arcana
	public static final ItemGroup LHARC_GROUP = FabricItemGroup.builder().icon(()-> new ItemStack(Items.BARRIER)).displayName(Text.translatable("lh_arcana")).build();
	
	

	//Blocks
	//Standard Case - Ores
	public static final Block Tin_Ore = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)); //Tin Ore
	public static final Block Tin_Ore_Deep = new Block(FabricBlockSettings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)); //Deepslate Tin Ore
	public static final Block Hexatium_Ore = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)); //Hexatium Ore
	public static final Block Uranium_Ore = new Block(FabricBlockSettings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)); //Uranium Ore
	public static final Block Lithium_Ore = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)); //Lithium Ore
	public static final Block Lithium_Ore_Deep = new Block(FabricBlockSettings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)); //Deepslate Lithium Ore
	public static final Block Aluminum_Ore = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)); //Laterite Ore
	public static final Block Galena_Ore = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)); //Galena Ore
	//Standard Case - Material Blocks
	public static final Block Tin_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL)); 
	public static final Block Lithium_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	public static final Block Aluminum_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	public static final Block Lead_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	public static final Block Silver_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	public static final Block Uranium_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	public static final Block Hexatium_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.METAL));
	//Standard Case - Crystal Blocks
	public static final Block Arcanite_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	public static final Block Nullix_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)); 
	public static final Block Pyrotite_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	public static final Block Crylatite_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	public static final Block Noxite_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	public static final Block Shoctite_Block = new Block(FabricBlockSettings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	//Crystals
	public static final CropBlock Arcanite_Crystal = new ArcaniteCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	public static final CropBlock Nullix_Crystal = new NullixCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	public static final CropBlock Pyrotite_Crystal = new PyrotiteCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	public static final CropBlock Crylatite_Crystal = new CrylatiteCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	public static final CropBlock Noxite_Crystal = new NoxiteCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	public static final CropBlock Shoctite_Crystal = new ShoctiteCrystal(FabricBlockSettings.create().nonOpaque().noCollision().ticksRandomly().hardness(1.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER));
	//Crystalline Sand
	public static final CrystallineSand Arcanite_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Arcanite_Crystal);
	public static final CrystallineSand Nullix_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Nullix_Crystal);
	public static final CrystallineSand Pyrotite_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Pyrotite_Crystal);
	public static final CrystallineSand Crylatite_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Crylatite_Crystal);
	public static final CrystallineSand Noxite_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Noxite_Crystal);
	public static final CrystallineSand Shoctite_Sand = new CrystallineSand(FabricBlockSettings.create().ticksRandomly().hardness(2.0f).sounds(BlockSoundGroup.SAND), Shoctite_Crystal);
	
	
	//Items
	//Materials - Raw
	public static final Item Tin_Raw = new Item(new FabricItemSettings()); //Tin Ore Item
	public static final Item Tin_Ref = new Item(new FabricItemSettings()); //Tin Ingot
	public static final Item Uranium_Raw = new Item(new FabricItemSettings()); //Uranium Ore Item
	public static final Item Uranium_Ref = new Item(new FabricItemSettings()); //Uranium Ingot
	public static final Item Lithium_Raw = new Item(new FabricItemSettings()); //Lithium Ore Item
	public static final Item Lithium_Ref = new Item(new FabricItemSettings()); //Lithium Ingot
	public static final Item Aluminum_Raw = new Item(new FabricItemSettings()); //Laterite (Aluminum Ore) Item
	public static final Item Aluminum_Ref = new Item(new FabricItemSettings()); //Aluminum Ingot
	public static final Item Hexatium_Raw = new Item(new FabricItemSettings()); //Hexatium Ore Item
	public static final Item Hexatium_Ref = new Item(new FabricItemSettings()); //Hexatium Ingot
	public static final Item Rubber_Raw = new Item(new FabricItemSettings()); //Raw Rubber
	public static final Item Rubber = new Item(new FabricItemSettings()); //Standard Rubber
	public static final Item Rubber_Ref = new Item(new FabricItemSettings()); //Vulcanized Rubber
	public static final Item Galena_Raw = new Item(new FabricItemSettings()); //Galena Ore Item
	public static final Item Lead_Ref = new Item(new FabricItemSettings()); //Lead Ingot
	public static final Item Silver_Ref = new Item(new FabricItemSettings()); //Silver Ingot
	public static final Item Sulfur = new Item(new FabricItemSettings()); //Lead Refinement Byproduct, Sulfur
	public static final Item Steel_Ingot = new Item(new FabricItemSettings()); //Steel Ingot
	//Materials - Arcane Crystal Shard
	public static final Item Arcanite_Shard = new Item(new FabricItemSettings()); //Arcanite Crystal - Arcane - Manipulates Arcana
	public static final Item Pyrotite_Shard = new Item(new FabricItemSettings()); //Pyrotite Crystal - Heat - burns entities
	public static final Item Crylatite_Shard = new Item(new FabricItemSettings()); //Crylatite Crystal - Cold - slows entities
	public static final Item Noxite_Shard = new Item(new FabricItemSettings()); //Noxite Crystal - Life - poisons entities
	public static final Item Shoctite_Shard = new Item(new FabricItemSettings()); //Shoctite Crystal - Lightning - stuns entities
	public static final Item Nullix_Shard = new Item(new FabricItemSettings()); //Nullix Crystal - Void - Manipulates the Void
	//Crystal "Seeds"
	public static final Item Arcanite_Seed = new AliasedBlockItem(Arcanite_Crystal, new FabricItemSettings());
	public static final Item Nullix_Seed = new AliasedBlockItem(Nullix_Crystal, new FabricItemSettings());
	public static final Item Pyrotite_Seed = new AliasedBlockItem(Pyrotite_Crystal, new FabricItemSettings());
	public static final Item Crylatite_Seed = new AliasedBlockItem(Crylatite_Crystal, new FabricItemSettings());
	public static final Item Noxite_Seed = new AliasedBlockItem(Noxite_Crystal, new FabricItemSettings());
	public static final Item Shoctite_Seed = new AliasedBlockItem(Shoctite_Crystal, new FabricItemSettings());

	//Block Entities


	//Worldgen - Biome Mod API - EXP
	//Ores
	public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "tin_ore"));
	public static final RegistryKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "lithium_ore"));
	public static final RegistryKey<PlacedFeature> ALUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "aluminum_ore"));
	public static final RegistryKey<PlacedFeature> GALENA_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "galena_ore"));
	public static final RegistryKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "uranium_ore"));
	public static final RegistryKey<PlacedFeature> HEXATIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("losthorizons", "hexatium_ore"));

	//Worldgen - Crystal Bubbles
	//private static final Feature<CrystalBubbleFeatureConfig> CRYSTALBUBBLE = new CrystalBubbleFeature(CrystalBubbleFeatureConfig.CODEC);
	//public static ConfiguredFeature<?,?> CON_ARCANITE_BUBBLE = new ConfiguredFeature(CRYSTALBUBBLE, new CrystalBubbleFeatureConfig(ConstantIntProvider.create(1), ConstantIntProvider.create(5), ConstantIntProvider.create(7), ConstantIntProvider.create(5), ConstantIntProvider.create(7), ConstantIntProvider.create(5), ConstantIntProvider.create(7), BlockStateProvider.of(Arcanite_Sand), BlockStateProvider.of(Arcanite_Block)));
	//public static PlacedFeature GEN_ARCANITE_BUBBLE = new PlacedFeature(RegistryEntry.of(CON_ARCANITE_BUBBLE), Arrays.asList(CountPlacementModifier.of(1), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.fixed(-56), YOffset.fixed(48))));

	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("LH Initialization Started");
		//Items
		//Materials - Raw
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "tin_raw"), Tin_Raw); 
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "tin_ingot"), Tin_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "uranium_raw"), Uranium_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "uranium_ingot"), Uranium_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lithium_raw"), Lithium_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lithium_ingot"), Lithium_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "aluminum_raw"), Aluminum_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "aluminum_ingot"), Aluminum_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "hexatium_raw"), Hexatium_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "hexatium_ingot"), Hexatium_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "rubber_raw"), Rubber_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "rubber"), Rubber);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "rubber_vulcanized"), Rubber_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "galena_raw"), Galena_Raw);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lead_ingot"), Lead_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "silver_ingot"), Silver_Ref);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "sulfur"), Sulfur);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "steel_ingot"), Steel_Ingot);
		//Materials - Arcane Crystals
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "arcanite"), Arcanite_Shard);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "nullix"), Nullix_Shard);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "pyrotite"), Pyrotite_Shard);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "crylatite"), Crylatite_Shard);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "noxite"), Noxite_Shard);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "shoctite"), Shoctite_Shard);
		//Crystal "Seeds"
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "arcanite_crystal_item"), Arcanite_Seed);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "nullix_crystal_item"), Nullix_Seed);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "pyrotite_crystal_item"), Pyrotite_Seed);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "crylatite_crystal_item"), Crylatite_Seed);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "noxite_crystal_item"), Noxite_Seed);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "shoctite_crystal_item"), Shoctite_Seed);

		//Blocks
		//Standard Case - Ores
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "tin_ore"), Tin_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "tin_ore"), new BlockItem(Tin_Ore, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "tin_ore_deep"), Tin_Ore_Deep);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "tin_ore_deep"), new BlockItem(Tin_Ore_Deep, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "hexatium_ore"), Hexatium_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "hexatium_ore"), new BlockItem(Hexatium_Ore, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "uranium_ore"), Uranium_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "uranium_ore"), new BlockItem(Uranium_Ore, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "lithium_ore"), Lithium_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lithium_ore"), new BlockItem(Lithium_Ore, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "lithium_ore_deep"), Lithium_Ore_Deep);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lithium_ore_deep"), new BlockItem(Lithium_Ore_Deep, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "aluminum_ore"), Aluminum_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "aluminum_ore"), new BlockItem(Aluminum_Ore, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "galena_ore"), Galena_Ore);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "galena_ore"), new BlockItem(Galena_Ore, new FabricItemSettings()));
		//Standard Case - Materials
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "tin_block"), Tin_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "tin_block"), new BlockItem(Tin_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "lithium_block"), Lithium_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lithium_block"), new BlockItem(Lithium_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "aluminum_block"), Aluminum_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "aluminum_block"), new BlockItem(Aluminum_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "lead_block"), Lead_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "lead_block"), new BlockItem(Lead_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "silver_block"), Silver_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "silver_block"), new BlockItem(Silver_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "uranium_block"), Uranium_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "uranium_block"), new BlockItem(Uranium_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "hexatium_block"), Hexatium_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "hexatium_block"), new BlockItem(Hexatium_Block, new FabricItemSettings()));
		//Standard Case - Crystals
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "arcanite_block"), Arcanite_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "arcanite_block"), new BlockItem(Arcanite_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "nullix_block"), Nullix_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "nullix_block"), new BlockItem(Nullix_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "pyrotite_block"), Pyrotite_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "pyrotite_block"), new BlockItem(Pyrotite_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "crylatite_block"), Crylatite_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "crylatite_block"), new BlockItem(Crylatite_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "noxite_block"), Noxite_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "noxite_block"), new BlockItem(Noxite_Block, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "shoctite_block"), Shoctite_Block);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "shoctite_block"), new BlockItem(Shoctite_Block, new FabricItemSettings()));
		//Crystalline Sand
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "arcanite_sand"), Arcanite_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "arcanite_sand"), new BlockItem(Arcanite_Sand, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "nullix_sand"), Nullix_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "nullix_sand"), new BlockItem(Nullix_Sand, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "pyrotite_sand"), Pyrotite_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "pyrotite_sand"), new BlockItem(Pyrotite_Sand, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "crylatite_sand"), Crylatite_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "crylatite_sand"), new BlockItem(Crylatite_Sand, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "noxite_sand"), Noxite_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "noxite_sand"), new BlockItem(Noxite_Sand, new FabricItemSettings()));
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "shoctite_sand"), Shoctite_Sand);
			Registry.register(Registries.ITEM, new Identifier("losthorizons", "shoctite_sand"), new BlockItem(Shoctite_Sand, new FabricItemSettings()));
		//Crystal "Crop"
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "arcanite_crystal"), Arcanite_Crystal);
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "nullix_crystal"), Nullix_Crystal);
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "pyrotite_crystal"), Pyrotite_Crystal);
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "crylatite_crystal"), Crylatite_Crystal);
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "noxite_crystal"), Noxite_Crystal);
			Registry.register(Registries.BLOCK, new Identifier("losthorizons", "shoctite_crystal"), Shoctite_Crystal);
		//Worldgen - Biome ModXP
		//Ores
		/* DEPRECATED -- USE JSON INSTEAD
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "tin_ore_std"), CON_TIN_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "tin_ore_std"), GEN_TIN_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registries.PLACED_FEATURE_KEY, new Identifier("losthorizons", "tin_ore_std")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "tin_ore_deep"), CON_TIN_ORE_DEEP);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "tin_ore_deep"), GEN_TIN_ORE_DEEP);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "tin_ore_deep")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "lithium_ore_std"), CON_LITHIUM_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "lithium_ore_std"), GEN_LITHIUM_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "lithium_ore_std")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "lithium_ore_deep"), CON_LITHIUM_ORE_DEEP);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "lithium_ore_deep"), GEN_LITHIUM_ORE_DEEP);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "lithium_ore_deep")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "aluminum_ore"), CON_ALUM_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "aluminum_ore"), GEN_ALUM_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "aluminum_ore")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "galena_ore"), CON_GALENA_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "galena_ore"), GEN_GALENA_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "galena_ore")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "uranium_ore"), CON_URANIUM_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "uranium_ore"), GEN_URANIUM_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "uranium_ore")));
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "hexatium_ore"), CON_HEXATIUM_ORE);
			Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "hexatium_ore"), GEN_HEXATIUM_ORE);
			BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "hexatium_ore")));
			 */
			//Group Registries
			Registry.register(Registries.ITEM_GROUP, new Identifier("losthorizons", "materials_group"), LHMAT_GROUP);
			Registry.register(Registries.ITEM_GROUP, new Identifier("losthorizons", "hybrid_group"), LHHYB_GROUP);
			Registry.register(Registries.ITEM_GROUP, new Identifier("losthorizons", "techna_group"), LHTEC_GROUP);
			Registry.register(Registries.ITEM_GROUP, new Identifier("losthorizons", "arcana_group"), LHARC_GROUP);

		//Crystal Bubbles
			//Registry.register(Registry.FEATURE, new Identifier("losthorizons","crystal_bubble"), CRYSTALBUBBLE);
			//Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("losthorizons", "arcanite_bubble"), CON_ARCANITE_BUBBLE);
			//Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("losthorizons", "arcanite_bubble"), GEN_ARCANITE_BUBBLE);
			//BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_STRUCTURES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("losthorizons", "arcanite_bubble")));
		}
}
