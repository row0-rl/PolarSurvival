package com.fakeworldmc.polarsurvival.client.model;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBackpackFurnace extends ModelBase {

    public ModelRenderer backpackFurnace;

    public ModelBackpackFurnace() {
        this.backpackFurnace = new ModelRenderer(this, 22, 0);
        this.backpackFurnace.addBox(0.0F, 0.0F, 0.0F, 10, 20, 10, 1.0F);

    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.backpackFurnace.render(scale);
        /*GlStateManager.disableRescaleNormal();
        GlStateManager.disableCull();

        if (entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).isChild())
        {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 1.5F, -0.1F);
            this.leftWing.render(scale);
            this.rightWing.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
            this.leftWing.render(scale);
            this.rightWing.render(scale);
        }

         */
    }
}
