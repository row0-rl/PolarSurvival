package com.fakeworldmc.polarsurvival.client.gui;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.init.Keys;
import com.fakeworldmc.polarsurvival.inventory.ContainerBackpackFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

import static org.lwjgl.input.Keyboard.KEY_E;
import static org.lwjgl.input.Keyboard.KEY_Z;

@SideOnly(Side.CLIENT)
public class GuiBackpackFurnace extends GuiContainer {

    private static final String TEXTURE_PATH = PolarSurvival.MODID + ":" + "textures/gui/container/gui_backpack_furnace.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);

    public GuiBackpackFurnace(InventoryPlayer playerInventory) {

        super(new ContainerBackpackFurnace(playerInventory));

        this.xSize = 176;
        this.ySize = 159;
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {

        if (keyCode == Keys.openBackpackFurnace.getKeyCode()) {
            this.mc.player.closeScreen();
        }
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String title = I18n.format("container.polarSurvival.backpackFurnace");

        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, 54, 0x404040);

    }
}