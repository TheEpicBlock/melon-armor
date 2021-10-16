package nl.theepicblock.melonarmor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MelonArmor implements ModInitializer {
	public static final String MODID = "melon-armor";

	public static final Identifier MELON_OVERLAY = id("textures/misc/melonoverlay.png");

	public static final MelonMaterial MELON_MATERIAL = new MelonMaterial();
	public static final FoodComponent MELON_ARMOR_FOOD = new FoodComponent.Builder().hunger(FoodComponents.MELON_SLICE.getHunger()*2).saturationModifier(FoodComponents.MELON_SLICE.getSaturationModifier()*2).build();

	public static final ArmorItem MELON_HELMET = new MelonArmorItem(MELON_MATERIAL, EquipmentSlot.HEAD, armorSettings());
	public static final ArmorItem MELON_CHESTPLATE = new MelonArmorItem(MELON_MATERIAL, EquipmentSlot.CHEST, armorSettings());
	public static final ArmorItem MELON_LEGGINGS = new MelonArmorItem(MELON_MATERIAL, EquipmentSlot.LEGS, armorSettings());
	public static final ArmorItem MELON_BOOTS = new MelonArmorItem(MELON_MATERIAL, EquipmentSlot.FEET, armorSettings());

	public static Item.Settings armorSettings() {
		return new Item.Settings().group(ItemGroup.COMBAT).food(MELON_ARMOR_FOOD);
	}

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
