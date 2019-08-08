package com.fakeworldmc.polarsurvival.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.EnumHelper;

public class ItemWoolenSuit extends ItemArmor {

    public ItemWoolenSuit(EntityEquipmentSlot slot) {
        super(WOOLEN_SUIT_MATERIAL, 0, slot);
    }

    public static final ArmorMaterial WOOLEN_SUIT_MATERIAL = EnumHelper.addArmorMaterial("wool",
            "polar_survival:wool", 2, new int[]{0, 0, 1, 0}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);

    @Override
    public boolean hasOverlay(ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
    }

    @Override
    public int getColor(ItemStack stack) {
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound != null)
        {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3))
            {
                return nbttagcompound1.getInteger("color");
            }
        }

        return 0xFFFFFF;
    }

    @Override
    public void setColor(ItemStack stack, int color) {
            NBTTagCompound nbttagcompound = stack.getTagCompound();

            if (nbttagcompound == null) {
                nbttagcompound = new NBTTagCompound();
                stack.setTagCompound(nbttagcompound);
            }

            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (!nbttagcompound.hasKey("display", 10)) {
                nbttagcompound.setTag("display", nbttagcompound1);
            }

            nbttagcompound1.setInteger("color", color);
    }
}