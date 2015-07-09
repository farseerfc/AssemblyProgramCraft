package org.apcdevpowered.apc.common.block;

import org.apcdevpowered.apc.common.creativetab.AssemblyProgramCraftCreativeTabs;
import org.apcdevpowered.apc.common.tileEntity.TileEntityVCPU32Computer;
import org.apcdevpowered.util.IntUtils;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The block of vcpu32 computer.
 * 
 * @author yuxuanchiadm
 * @see org.apcdevpowered.apc.common.tileEntity.TileEntityVCPU32Computer
 * @see org.apcdevpowered.apc.client.renderer.tileentity.RenderTileEntityVCPU32Computer
 * @see org.apcdevpowered.vcpu32.vm.VirtualMachine
 * @since a1.0.0
 */
public class BlockVCPU32Computer extends BlockContainer
{
    /** The the block state property of block`s face. */
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    /**
     * Constructs a block.
     */
    public BlockVCPU32Computer()
    {
        super(Material.rock);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(AssemblyProgramCraftCreativeTabs.tabApc);
    }
    /**
     * Returns a new instance of a block's tile entity class. Called on placing
     * the block.
     * 
     * @param worldIn
     *            The world of block in.
     * 
     * @param meta
     *            The metadata of the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityVCPU32Computer();
    }
    /**
     * Called when block activated by player.
     * 
     * @param worldIn
     *            The world of block activated in.
     * 
     * @param pos
     *            The location of block activated at.
     * 
     * @param state
     *            The state of block activated with.
     * 
     * @param playerIn
     *            Who activated this block.
     * 
     * @param side
     *            The side which is activated.
     * 
     * @param hitX
     *            The x axis position of activated position.
     * 
     * @param hitY
     *            The y axis position of activated position.
     * 
     * @param hitZ
     *            The z axis position of activated position.
     * 
     * @return Whether block response.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side.getAxis().isHorizontal())
        {
            EnumFacing facingSide = EnumFacing.getHorizontal(IntUtils.cycleInt(((EnumFacing) state.getValue(FACING)).getHorizontalIndex() - side.getHorizontalIndex(), EnumFacing.HORIZONTALS.length));
            float offX = 0.0F;
            float offY = 0.0F;
            if(side == EnumFacing.NORTH)
            {
                offX = hitX;
                offY = hitY;
            }
            if(side == EnumFacing.SOUTH)
            {
                offX = 1.0F - hitX;
                offY = hitY;
            }
            if(side == EnumFacing.WEST)
            {
                offX = 1.0F - hitZ;
                offY = hitY;
            }
            if(side == EnumFacing.EAST)
            {
                offX = hitZ;
                offY = hitY;
            }
            if (facingSide == EnumFacing.SOUTH)
            {
                if ((offX >= (6.0 / 16.0)) && (offX <= (7.0 / 16.0)) && (offY >= (5.0 / 16.0)) && (offY <= (6.0 / 16.0)))
                {
                    if (worldIn.isRemote)
                    {
                        return true;
                    }
                    TileEntityVCPU32Computer tileentity = (TileEntityVCPU32Computer) worldIn.getTileEntity(pos);
                    if (tileentity == null)
                    {
                        return false;
                    }
                    tileentity.turnPower();
                    return true;
                }
            }
            if (facingSide == EnumFacing.EAST || facingSide == EnumFacing.WEST)
            {
                if (worldIn.isRemote)
                {
                    return true;
                }
                TileEntityVCPU32Computer tileentity = (TileEntityVCPU32Computer) worldIn.getTileEntity(pos);
                if (tileentity == null)
                {
                    return false;
                }
                tileentity.modifyComputer(playerIn);
                return true;
            }
        }
        return false;
    }
    /**
     * Get the block collision box.
     * 
     * @param worldIn
     *            The world of block in.
     * 
     * @param pos
     *            The position of block at.
     * 
     * @param state
     *            The block state of the block.
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        // Set block bounds first.
        this.setBlockBoundsBasedOnState(worldIn, pos);
        return super.getCollisionBoundingBox(worldIn, pos, state);
    }
    /**
     * Set the block bounds.
     * 
     * @param worldIn
     *            The world of block in.
     * 
     * @param pos
     *            The position of block at.
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        if (iblockstate.getBlock() == this)
        {
            if (iblockstate.getValue(FACING) == EnumFacing.NORTH)
            {
                this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.75F, 1.0F);
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.EAST)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.25F, 0.75F, 0.75F, 0.75F);
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.SOUTH)
            {
                this.setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 0.75F, 0.75F);
            }
            else if (iblockstate.getValue(FACING) == EnumFacing.WEST)
            {
                this.setBlockBounds(0.25F, 0.0F, 0.25F, 1.0F, 0.75F, 0.75F);
            }
        }
    }
    /**
     * Called when living placed a block.
     * 
     * @param worldIn
     *            The world of block placed in.
     * 
     * @param pos
     *            The location of block placed at.
     * 
     * @param state
     *            The state of block placed with.
     * 
     * @param placer
     *            What living placed this block.
     * 
     * @param stack
     *            The item stack of the placer hold in hand.
     */
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
    }
    /**
     * Called when block is break.
     * 
     * @param worldIn
     *            The world of block placed in.
     * 
     * @param pos
     *            The location of block placed at.
     * 
     * @param state
     *            The state of block placed with.
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityVCPU32Computer tileentity = (TileEntityVCPU32Computer) worldIn.getTileEntity(pos);
        super.breakBlock(worldIn, pos, state);
        tileentity.updataConnector(state);
        InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
        worldIn.updateComparatorOutputLevel(pos, this);
    }
    /**
     * Returns whether is a opaque block.
     * 
     * @return Whether is a opaque block.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    /**
     * Returns whether is a full cube.
     * 
     * @return Whether is a full cuble.
     */
    @Override
    public boolean isFullCube()
    {
        return false;
    }
    /**
     * Returns the type of render function that is called for this block.
     * 
     * @return The type of render function that is called for this block.
     */
    @Override
    public int getRenderType()
    {
        return -1;
    }
    /**
     * Convert the given metadata into a block state for this Block.
     * 
     * @param meta
     *            Metadata convert from.
     * 
     * @return Block state convert from metadata.
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }
    /**
     * Convert the block state into the correct metadata value.
     * 
     * @param state
     *            Block state convert from.
     * 
     * @return Metadata convert from block state.
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
    }
    /**
     * Create block state of this block.
     * 
     * @return Block state of this block.
     */
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, FACING);
    }
}