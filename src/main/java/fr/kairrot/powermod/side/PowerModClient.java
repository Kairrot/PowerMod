package fr.kairrot.powermod.side;

import fr.kairrot.powermod.PowerMod;
import fr.kairrot.powermod.gui.CustomOptionsScreen;
import fr.kairrot.powermod.gui.GuiCustomMainMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PowerModClient {

    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(PowerMod.MODID),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public void load() {
        MinecraftForge.EVENT_BUS.addListener(this::openGui);
    }

    @SubscribeEvent
    public void openGui(GuiOpenEvent event) {
        Minecraft mc = Minecraft.getInstance();

        if(event.getGui() != null) {
            if(event.getGui().getClass() == MainMenuScreen.class) {
                event.setGui(new GuiCustomMainMenu());
            } else if(event.getGui().getClass() == OptionsScreen.class) {
                event.setGui(new CustomOptionsScreen(mc.screen, mc.options));
            }
        }
    }
}
