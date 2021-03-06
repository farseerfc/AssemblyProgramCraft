package org.apcdevpowered.apc.client.gui.screen;

import org.apcdevpowered.apc.common.container.ContainerComputerModify;
import org.apcdevpowered.apc.common.tileEntity.TileEntityVCPU32Computer;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiComputerModify extends GuiContainer
{
    private static final ResourceLocation guiComputerModifyTextures = new ResourceLocation("AssemblyProgramCraft:textures/gui/gui_computer_modify.png");
    
    public GuiComputerModify(InventoryPlayer inventory, TileEntityVCPU32Computer computerTileEntity)
    {
        super(new ContainerComputerModify(inventory, computerTileEntity));
        this.xSize = 176;
        this.ySize = 187;
    }
    @Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(guiComputerModifyTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        fontRendererObj.drawString("BIOS芯片插槽", x + 10, y + 56, 0x404040);
    }
}
