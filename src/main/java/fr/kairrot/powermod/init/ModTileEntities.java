package fr.kairrot.powermod.init;

import fr.kairrot.powermod.PowerMod;
import fr.kairrot.powermod.tileentity.TileEntityStoreBlock;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, PowerMod.MODID);

    public static final RegistryObject<TileEntityType<?>> STORE_BLOCK = TILE_ENTITIES.register("store_block",
            () -> TileEntityType.Builder.of(TileEntityStoreBlock::new, ModBlocks.STORE_BLOCK.get()).build(null));
}
