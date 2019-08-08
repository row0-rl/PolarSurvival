package com.fakeworldmc.polarsurvival.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ItemBackpackFurnace extends ItemArmor {
    public static final ArmorMaterial WOOLEN_SUIT_MATERIAL = EnumHelper.addArmorMaterial("backpack_furnace",
            "polar_survival:backpack_furnace", 0, new int[]{0, 0, 0, 0}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

    public ItemBackpackFurnace() {
        super(WOOLEN_SUIT_MATERIAL, 0, EntityEquipmentSlot.CHEST);
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setTranslationKey("backpackFurnace");
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        return HashMultimap.<String, AttributeModifier>create();
    }

    /*@Override
    public EntityEquipmentSlot getEquipmentSlot(ItemStack stack)
    {
        return EntityEquipmentSlot.CHEST;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        EntityEquipmentSlot slot = EntityEquipmentSlot.CHEST;

        if (playerIn.getItemStackFromSlot(slot).isEmpty())
        {
            playerIn.setItemStackToSlot(slot, itemstack.copy());
            itemstack.setCount(0);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }

     */

    /*@Override
    @SideOnly(Side.CLIENT)
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
        return null;
    }

     */

    /*@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "polar_survival/models/backpack_furnace_layer_1.png";
    }

     */


}
