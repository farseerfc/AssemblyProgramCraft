package yuxuanchiadm.apc.apc.common.init;

import yuxuanchiadm.apc.apc.common.init.blockRegistry.AssemblyProgramCraftBlockRegistry;
import yuxuanchiadm.apc.apc.common.init.blockRegistry.AssemblyProgramCraftItemRegistry;

public class AssemblyProgramCraftBootstrap
{
    private static boolean alreadyRegistered = false;
    
    public static boolean isRegistered()
    {
        return alreadyRegistered;
    }
    
    public static void register()
    {
        if (!alreadyRegistered)
        {
            alreadyRegistered = true;
            
            AssemblyProgramCraftBlockRegistry.registerBlocks();
            AssemblyProgramCraftItemRegistry.registerItems();
        }
    }
}