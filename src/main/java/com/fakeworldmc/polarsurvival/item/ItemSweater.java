package com.fakeworldmc.polarsurvival.item;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.attribute.Attribute;
import com.fakeworldmc.polarsurvival.init.Guis;
import com.google.common.collect.Multimap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSweater extends ItemWoolenSuit {

    public ItemSweater() {
        super(EntityEquipmentSlot.CHEST);
        this.setTranslationKey("sweater");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.CHEST) {
            Double amount = Attribute.getAttributeWarmthAmount(0.48, stack);
            multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                    "Tool Modifier", amount, 1));
        }
        return multimap;
    }

    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        BlockPos pos = player.getPosition();

            player.openGui(PolarSurvival.instance, 1, world, pos.getX(), pos.getY(), pos.getZ());
            return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));


    }

     */
}

