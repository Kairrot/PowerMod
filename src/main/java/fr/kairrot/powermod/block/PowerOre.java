package fr.kairrot.powermod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class PowerOre extends Block {

    public PowerOre() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(4f, 15f).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops());
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 4,8) : 0;
    }
}
