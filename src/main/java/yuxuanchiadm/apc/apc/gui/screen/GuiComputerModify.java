package yuxuanchiadm.apc.apc.gui.screen;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import yuxuanchiadm.apc.apc.container.ContainerComputerModify;
import yuxuanchiadm.apc.apc.tileEntity.TileEntityVCPU32Computer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiComputerModify extends GuiContainer
{
    private static final ResourceLocation guiComputerModifyTextures = new ResourceLocation("AssemblyProgramCraft:textures/gui/GuiComputerModify.png");
    public GuiComputerModify(InventoryPlayer inventory, TileEntityVCPU32Computer computerTileEntity)
    {
        super(new ContainerComputerModify(inventory, computerTileEntity));
        this.xSize = 176;
        this.ySize = 187;
    }
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(guiComputerModifyTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        fontRendererObj.drawString("BIOS芯片插槽", x + 10, y + 56, 0x404040);
    }
}
