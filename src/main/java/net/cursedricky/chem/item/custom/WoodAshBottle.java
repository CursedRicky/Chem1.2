package net.cursedricky.chem.item.custom;

import net.cursedricky.chem.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Mortar_and_pestle extends Item {

    public Mortar_and_pestle(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        return container;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

}
