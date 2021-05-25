package fr.kairrot.powermod.gui;

import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class CustomOptionsScreen extends OptionsScreen {

    public CustomOptionsScreen(Screen screen, GameSettings settings) {
        super(screen, settings);
    }

    @Override
    protected void init() {
        super.init();

        this.addButton(new Button(this.width / 2 - 50, (int) (this.height * 0.75), 100,20, new StringTextComponent("Solo"), button -> {
            this.minecraft.setScreen(new ConfirmSoloScreen());
        }));
    }
}
