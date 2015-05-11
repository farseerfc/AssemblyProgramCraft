package yuxuanchiadm.apc.apc.network;

import yuxuanchiadm.apc.apc.container.ContainerBIOSWriter;
import yuxuanchiadm.apc.apc.container.ContainerComputerModify;
import yuxuanchiadm.apc.apc.gui.screen.GuiBIOSWriter;
import yuxuanchiadm.apc.apc.gui.screen.GuiComputerModify;
import yuxuanchiadm.apc.apc.gui.screen.GuiKeyboard;
import yuxuanchiadm.apc.apc.gui.screen.GuiPortSetting;
import yuxuanchiadm.apc.apc.tileEntity.ITileEntityExternalDevice;
import yuxuanchiadm.apc.apc.tileEntity.TileEntityExternalDeviceKeyboard;
import yuxuanchiadm.apc.apc.tileEntity.TileEntityVCPU32Computer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class AssemblyProgramCraftGuiHandler implements IGuiHandler
{
    public static final int BIOS_WRITER_GUI_ID = 0;
    public static final int COMPUTER_MODIFY_GUI_ID = 1;
    public static final int KEYBOARD_GUI_ID = 2;
    public static final int ID_SETTIING_GUI_ID = 3;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == BIOS_WRITER_GUI_ID)
        {
            return new ContainerBIOSWriter(player.inventory);
        }
        else if(ID == COMPUTER_MODIFY_GUI_ID)
        {
            TileEntityVCPU32Computer tileentity = (TileEntityVCPU32Computer)world.getTileEntity(new BlockPos(x, y, z));
            if(tileentity == null)
            {
                return null;
            }
            return new ContainerComputerModify(player.inventory, tileentity);
        }
        else
        {
            return null;
        }
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == BIOS_WRITER_GUI_ID)
        {
            return new GuiBIOSWriter(player.inventory);
        }
        else if(ID == COMPUTER_MODIFY_GUI_ID)
        {
            TileEntityVCPU32Computer tileentity = (TileEntityVCPU32Computer)world.getTileEntity(new BlockPos(x, y, z));
            if(tileentity == null)
            {
                return null;
            }
            return new GuiComputerModify(player.inventory, tileentity);
        }
        else if(ID == KEYBOARD_GUI_ID)
        {
            TileEntityExternalDeviceKeyboard tileentity = (TileEntityExternalDeviceKeyboard)world.getTileEntity(new BlockPos(x, y, z));
            if(tileentity == null)
            {
                return null;
            }
            return new GuiKeyboard(tileentity);
        }
        else if(ID == ID_SETTIING_GUI_ID)
        {
            TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
            if(tileEntity instanceof ITileEntityExternalDevice)
            {
                ITileEntityExternalDevice tileentityDevice = (ITileEntityExternalDevice)tileEntity;
                return new GuiPortSetting(tileentityDevice);
            }
            return null;
        }
        else
        {
            return null;
        }
    }
}
