package fr.kairrot.powermod.tileentity;

import fr.kairrot.powermod.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityStoreBlock extends TileEntity implements ITickableTileEntity {
    private int counter = 0;

    public TileEntityStoreBlock() {
        super(ModTileEntities.STORE_BLOCK.get());
    }

    @Override
    public void load(BlockState state, CompoundNBT compound) {
        super.load(state, compound);

        this.setCounter(compound.getInt("counter"));
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);

        compound.putInt("counter", this.getCounter());

        return compound;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void tick() {
        setCounter(getCounter() + 1);
    }
}
