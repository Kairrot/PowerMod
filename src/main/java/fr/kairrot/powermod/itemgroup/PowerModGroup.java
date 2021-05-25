package fr.kairrot.powermod.itemgroup;

import fr.kairrot.powermod.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PowerModGroup extends ItemGroup {
    public PowerModGroup() {
        super("PowerMod Tab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.POWER.get());
    }
}
