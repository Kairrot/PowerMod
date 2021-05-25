package fr.kairrot.powermod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.WorldSelectionScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.lwjgl.system.CallbackI;

public class ConfirmSoloScreen extends Screen {

    private TextFieldWidget password;

    protected ConfirmSoloScreen() {
        super(new StringTextComponent("confirmSoloScreen"));
    }

    @Override
    protected void init() {
        super.init();

        this.password = new TextFieldWidget(this.font, this.width / 2 - 100, this.height / 2 - 10, 200,20, (TextFieldWidget) null, new StringTextComponent("Mot de passe"));
        this.password.setValue("");
        this.password.setMaxLength(158);
        this.password.setResponder(this::onEdited);
        this.password.setFocus(true);
        this.children.add(this.password);
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float particals) {
        this.renderBackground(stack);

        this.password.render(stack, mouseX, mouseY, particals);

        drawCenteredString(stack, this.font, "Mot de passe", this.width / 2, this.height / 2 - 30, 0xFFFFFF);

        super.render(stack, mouseX, mouseY, particals);
    }

    public void onEdited(String edit) {
        if(edit.equals("frasne")) {
            this.minecraft.setScreen(new WorldSelectionScreen(this));
        }
    }
}
