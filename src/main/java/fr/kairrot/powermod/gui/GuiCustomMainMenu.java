package fr.kairrot.powermod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.kairrot.powermod.PowerMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.RenderSkybox;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;

public class GuiCustomMainMenu extends Screen {

    public GuiCustomMainMenu() {
        super(new StringTextComponent("powerMod"));
    }

    public static final RenderSkyboxCube CUBE_MAP = new RenderSkyboxCube(new ResourceLocation(PowerMod.MODID,"textures/gui/title/background/panorama"));
    public final RenderSkybox panorama = new RenderSkybox(CUBE_MAP);

    private long firstRenderTime;

    private MatrixStack stack;

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float particalTicks) {
        this.stack = stack;

        if(this.firstRenderTime == 0L) {
            this.firstRenderTime = Util.getMillis();
        }

        this.panorama.render(particalTicks, MathHelper.clamp(Util.getMillis() - this.firstRenderTime, 0.0F, 0.1F));

        addButton();
        addDefault();

        super.render(stack, mouseX, mouseY, particalTicks);
    }

    public void addDefault() {
        Minecraft mc = Minecraft.getInstance();

        mc.getTextureManager().bind(new ResourceLocation(PowerMod.MODID, "textures/gui/banner.png"));
        this.blit(stack, (int) (this.width / 2) - 158, (int) (this.height * 0.30) - 50, 317, 100, 0F, 0F, 32,32,32,32);

        drawCenteredString(stack, mc.font, "PowerCity v1.0 - 2021", this.width / 2, this.height - 10, 0xFFFFFF);
    }

    public void addButton() {
        int buttonHeight = (int) Math.round(height * 0.65);
        this.addButton(new ImageButton(width / 2 - 60, buttonHeight, 60, 15, 0, 0, 15, new ResourceLocation(PowerMod.MODID ,"textures/gui/connect.png"), 60, 30, button -> {
            connectServer("185.157.246.55:25565");
        }));

        this.addButton(new ImageButton(width / 2, buttonHeight, 60, 15, 0, 0, 15, new ResourceLocation(PowerMod.MODID, "textures/gui/options.png"), 60,30, button -> {
            this.minecraft.setScreen(new OptionsScreen(this, this.minecraft.options));
        }));
    }

    public void connectServer(String ip) {
        this.minecraft.setScreen(new ConnectingScreen(this, this.minecraft, new ServerData("Server", ip, true)));
    }
}
