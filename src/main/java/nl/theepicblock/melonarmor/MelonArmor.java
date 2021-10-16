package nl.theepicblock.melonarmor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MelonArmor implements ModInitializer {
	public static final String MODID = "melon-armor";

	public static final Identifier MELON_OVERLAY = id("textures/misc/melonoverlay.png");

	public static final MelonMaterial MELON_MATERIAL = new MelonMaterial();
	public static final ArmorItem MELON_HELMET = new ArmorItem(MELON_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ArmorItem MELON_CHESTPLATE = new ArmorItem(MELON_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ArmorItem MELON_LEGGINGS = new ArmorItem(MELON_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
	public static final ArmorItem MELON_BOOTS = new ArmorItem(MELON_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, id("melon_helmet"), MELON_HELMET);
		Registry.register(Registry.ITEM, id("melon_chestplate"), MELON_CHESTPLATE);
		Registry.register(Registry.ITEM, id("melon_leggings"), MELON_LEGGINGS);
		Registry.register(Registry.ITEM, id("melon_boots"), MELON_BOOTS);
	}

	private static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
