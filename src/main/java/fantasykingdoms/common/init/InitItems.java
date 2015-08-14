package fantasykingdoms.common.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import cpw.mods.fml.common.registry.GameRegistry;

import boilerplate.common.baseclasses.items.tools.BaseAxe;
import boilerplate.common.baseclasses.items.tools.BaseHoe;
import boilerplate.common.baseclasses.items.tools.BasePickaxe;
import boilerplate.common.baseclasses.items.tools.BaseShovel;
import boilerplate.common.baseclasses.items.tools.BaseSword;
import boilerplate.common.utils.helpers.RegistryHelper;
import fantasykingdoms.common.FantasyKingdoms;
import fantasykingdoms.common.items.ItemGem;
import fantasykingdoms.common.items.ItemIngot;
import fantasykingdoms.common.items.ItemNormalArmor;
import fantasykingdoms.common.items.ItemNugget;
import fantasykingdoms.common.items.ItemStygiumRing;
import fantasykingdoms.common.items.ItemWizardsKey;
import fantasykingdoms.common.items.dwarven.ItemEmptyTankard;
import fantasykingdoms.common.items.dwarven.ItemRune;
import fantasykingdoms.common.items.dwarven.ItemTankard;
import fantasykingdoms.common.items.tools.ItemModBattleaxe;
import fantasykingdoms.common.lib.ModInfo;
import fantasykingdoms.common.util.MaterialHelper;

/**
 * Created by Toby on 20/02/2015.
 */
public class InitItems
{
	public static Item itemGem;
	public static Item itemIngot;
	public static Item itemNugget;

	public static Item itemEmptyTankard;
	public static Item itemFullTankard;

	public static Item itemPlateHelmet, itemPlateChestplate, itemPlateLeggings, itemPlateBoots;
	// Tunic
	public static Item itemChainmailHelmet, itemChainmailChestplate, itemChainmailLeggings, itemChainmailBoots;
	// Crowned Helmet | Golden, with Red Cloak
	public static Item itemKingHelmet, itemKingChestplate, itemKingLeggings, itemKingBoots;
	//
	public static Item itemHellfireHelmet, itemHellfireChestplate, itemHellfireLeggings, itemHellfireBoots;

	public static Item itemJewelledSword, itemJewelledPickaxe, itemJewelledAxe, itemJewelledShovel, itemJewelledHoe;

	public static Item itemSilverSword, itemSilverPickaxe, itemSilverAxe, itemSilverShovel, itemSilverHoe;

	public static Item itemElvenLongbow, itemElvenShortbow, itemDwarvenCrossbow, itemBolt;

	public static Item itemStoneWarhammer, itemIronWarhammer, itemGoldWarhammer, itemDiamondWarhammer, itemJewelledWarhammer, itemSilverWarhammer,
			itemMithrilWarhammer;

	public static Item itemStoneBattleaxe, itemIronBattleaxe, itemGoldBattleaxe, itemDiamondBattleaxe, itemJewelledBattleaxe, itemSilverBattleaxe,
			itemMithrilBattleaxe;

	public static Item itemStoneMace, itemIronMace, itemGoldMace, itemDiamondMace, itemJewelledMace, itemSilverMace, itemMithrilMace;

	public static Item itemRuneblade;

	public static Item itemStygiumRing;

	public static Item itemWizardsKey;

	public static Item itemRune;

	public static void registerItems()
	{
		itemGem = new ItemGem().setUnlocalizedName("itemGem");
		GameRegistry.registerItem(itemGem, "ItemGem");
		itemIngot = new ItemIngot().setUnlocalizedName("itemIngot");
		GameRegistry.registerItem(itemIngot, "ItemIngot");
		itemNugget = new ItemNugget().setUnlocalizedName("itemNugget");
		GameRegistry.registerItem(itemNugget, "ItemNugget");

		itemStygiumRing = new ItemStygiumRing().setUnlocalizedName("itemStygiumRing");
		GameRegistry.registerItem(itemStygiumRing, "ItemStygiumRing");

		itemEmptyTankard = new ItemEmptyTankard().setUnlocalizedName("itemEmptyTankard");
		GameRegistry.registerItem(itemEmptyTankard, "ItemEmptyTankard");
		itemFullTankard = new ItemTankard().setUnlocalizedName("itemFullTankard");
		GameRegistry.registerItem(itemFullTankard, "ItemTankard");

		itemWizardsKey = new ItemWizardsKey().setUnlocalizedName("itemWizardsKey");
		// GameRegistry.registerItem(itemWizardsKey, "ItemWizardsKey");

		itemPlateHelmet = new ItemNormalArmor(MaterialHelper.ARMOR_PLATE, 0, "plate").setUnlocalizedName("itemHelmetPlate");
		itemPlateChestplate = new ItemNormalArmor(MaterialHelper.ARMOR_PLATE, 1, "plate").setUnlocalizedName("itemChestplatePlate");
		itemPlateLeggings = new ItemNormalArmor(MaterialHelper.ARMOR_PLATE, 2, "plate").setUnlocalizedName("itemLegsPlate");
		itemPlateBoots = new ItemNormalArmor(MaterialHelper.ARMOR_PLATE, 3, "plate").setUnlocalizedName("itemBootsPlate");

		RegistryHelper.registerArmorSet(itemPlateHelmet, itemPlateChestplate, itemPlateLeggings, itemPlateBoots, "Plate", ModInfo.MODID);

		itemChainmailHelmet = new ItemNormalArmor(MaterialHelper.ARMOR_CHAINMAIL, 0, "chainmail").setUnlocalizedName("itemHelmetChainmail");
		itemChainmailChestplate = new ItemNormalArmor(MaterialHelper.ARMOR_CHAINMAIL, 1, "chainmail").setUnlocalizedName("itemChainmailChestplate");
		itemChainmailLeggings = new ItemNormalArmor(MaterialHelper.ARMOR_CHAINMAIL, 2, "chainmail").setUnlocalizedName("itemLegsChainmail");
		itemChainmailBoots = new ItemNormalArmor(MaterialHelper.ARMOR_CHAINMAIL, 3, "chainmail").setUnlocalizedName("itemBootsChainmail");

		RegistryHelper.registerArmorSet(itemChainmailHelmet, itemChainmailChestplate, itemChainmailLeggings, itemChainmailBoots, "Chainmail",
				ModInfo.MODID);

		// Jewelled
		itemJewelledPickaxe = new BasePickaxe(MaterialHelper.TOOL_JEWELLED, ModInfo.PREFIX).setUnlocalizedName("itemPickaxeJewelled")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemJewelledSword = new BaseSword(MaterialHelper.TOOL_JEWELLED, ModInfo.PREFIX).setUnlocalizedName("itemSwordJewelled")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemJewelledShovel = new BaseShovel(MaterialHelper.TOOL_JEWELLED, ModInfo.PREFIX).setUnlocalizedName("itemShovelJewelled")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemJewelledAxe = new BaseAxe(MaterialHelper.TOOL_JEWELLED, ModInfo.PREFIX).setUnlocalizedName("itemAxeJewelled")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemJewelledHoe = new BaseHoe(MaterialHelper.TOOL_JEWELLED, ModInfo.PREFIX).setUnlocalizedName("itemHoeJewelled")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);

		RegistryHelper.registerToolSet(itemJewelledSword, itemJewelledShovel, itemJewelledPickaxe, itemJewelledAxe, itemJewelledHoe, "Jewelled",
				ModInfo.MODID);

		// Silver
		itemSilverPickaxe = new BasePickaxe(MaterialHelper.TOOL_SILVER, ModInfo.PREFIX).setUnlocalizedName("itemPickaxeSilver")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemSilverSword = new BaseSword(MaterialHelper.TOOL_SILVER, ModInfo.PREFIX).setUnlocalizedName("itemSwordSilver")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemSilverShovel = new BaseShovel(MaterialHelper.TOOL_SILVER, ModInfo.PREFIX).setUnlocalizedName("itemShovelSilver")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemSilverAxe = new BaseAxe(MaterialHelper.TOOL_SILVER, ModInfo.PREFIX).setUnlocalizedName("itemAxeSilver")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);
		itemSilverHoe = new BaseHoe(MaterialHelper.TOOL_SILVER, ModInfo.PREFIX).setUnlocalizedName("itemHoeSilver")
				.setCreativeTab(FantasyKingdoms.tabKingdoms);

		RegistryHelper.registerToolSet(itemSilverSword, itemSilverShovel, itemSilverPickaxe, itemSilverAxe, itemSilverHoe, "Silver", ModInfo.MODID);

		itemStoneBattleaxe = new ItemModBattleaxe(ToolMaterial.STONE).setUnlocalizedName("itemBattleaxeStone");
		itemIronBattleaxe = new ItemModBattleaxe(ToolMaterial.IRON).setUnlocalizedName("itemBattleaxeIron");
		itemGoldBattleaxe = new ItemModBattleaxe(ToolMaterial.GOLD).setUnlocalizedName("itemBattleaxeGold");
		itemDiamondBattleaxe = new ItemModBattleaxe(ToolMaterial.EMERALD).setUnlocalizedName("itemBattleaxeDiamond");

		itemRune = new ItemRune().setUnlocalizedName("itemRune");
		GameRegistry.registerItem(itemRune, "ItemRune");
	}
}
