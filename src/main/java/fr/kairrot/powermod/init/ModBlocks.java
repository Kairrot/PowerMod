package fr.kairrot.powermod.init;

import fr.kairrot.powermod.PowerMod;
import fr.kairrot.powermod.block.PowerOre;
import fr.kairrot.powermod.block.StoreBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PowerMod.MODID);

    public static final RegistryObject<Block> POWER_BLOCK = createBlock("power_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(5f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POWER_ORE = createBlock("power_ore", PowerOre::new);

    public static final RegistryObject<Block> STORE_BLOCK = createBlock("store_block", StoreBlock::new);

    public static RegistryObject<Block> createBlock(String name, Supplier<Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(PowerMod.powerModGroup)));
        return block;
    }
}
