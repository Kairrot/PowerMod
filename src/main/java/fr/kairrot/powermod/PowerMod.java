package fr.kairrot.powermod;

import fr.kairrot.powermod.init.ModBlocks;
import fr.kairrot.powermod.init.ModFeatures;
import fr.kairrot.powermod.init.ModItems;
import fr.kairrot.powermod.init.ModTileEntities;
import fr.kairrot.powermod.itemgroup.PowerModGroup;
import fr.kairrot.powermod.side.PowerModClient;
import fr.kairrot.powermod.side.PowerModServer;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(PowerMod.MODID)
public class PowerMod {

    public static final String MODID = "powermod";
    public static final ItemGroup powerModGroup = new PowerModGroup();

    public PowerMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::setupClient);

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);

        if(FMLEnvironment.dist == Dist.CLIENT) {
            new PowerModClient().load();
        } else if(FMLEnvironment.dist == Dist.DEDICATED_SERVER) {
            new PowerModServer().load();
        }
    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {
        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
    }

    @SubscribeEvent
    public void setupClient(FMLClientSetupEvent event) {

    }
}
