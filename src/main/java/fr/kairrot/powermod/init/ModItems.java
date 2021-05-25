package fr.kairrot.powermod.init;

import fr.kairrot.powermod.PowerMod;
import fr.kairrot.powermod.util.CustomItemTiers;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PowerMod.MODID);

    public static final RegistryObject<Item> POWER = ITEMS.register("power", () -> new Item(new Item.Properties().tab(PowerMod.powerModGroup)));

    public static final RegistryObject<Item> POWER_SWORD = ITEMS.register("power_sword", () -> new SwordItem(CustomItemTiers.POWER, 4, -2.4f, new Item.Properties().stacksTo(1).tab(PowerMod.powerModGroup)));
    public static final RegistryObject<Item> POWER_PICKAXE = ITEMS.register("power_pickaxe", () -> new PickaxeItem(CustomItemTiers.POWER, 0, -2.4f, new Item.Properties().stacksTo(1).tab(PowerMod.powerModGroup)));
    public static final RegistryObject<Item> POWER_SHOVEL = ITEMS.register("power_shovel", () -> new ShovelItem(CustomItemTiers.POWER, 0, -2.4f, new Item.Properties().stacksTo(1).tab(PowerMod.powerModGroup)));
    public static final RegistryObject<Item> POWER_AXE = ITEMS.register("power_axe", () -> new AxeItem(CustomItemTiers.POWER, 3, -2.4f, new Item.Properties().stacksTo(1).tab(PowerMod.powerModGroup)));
}