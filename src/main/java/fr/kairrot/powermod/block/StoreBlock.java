package fr.kairrot.powermod.block;

import fr.kairrot.powermod.tileentity.TileEntityStoreBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class StoreBlock extends Block {

    public StoreBlock() {
        super(AbstractBlock.Properties.of(Material.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityStoreBlock();
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if(world.getBlockEntity(pos) instanceof TileEntityStoreBlock) {
            TileEntityStoreBlock entity = (TileEntityStoreBlock) world.getBlockEntity(pos);

            player.displayClientMessage(new StringTextComponent("Counter : " + Integer.toString(entity.getCounter())), true);
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
