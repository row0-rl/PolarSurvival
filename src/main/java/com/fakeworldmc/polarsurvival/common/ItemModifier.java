package com.fakeworldmc.polarsurvival.common;

import com.fakeworldmc.polarsurvival.attribute.Attribute;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

@Mod.EventBusSubscriber(modid = "polar_survival")
public class ItemModifier {

    private static ItemArmor leatherHelmet = new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.HEAD) {
                Double amount = Attribute.getAttributeWarmthAmount(0.1, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    public static ItemArmor leatherChestplate = new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.CHEST) {
                Double amount = Attribute.getAttributeWarmthAmount(0.16, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    public static ItemArmor leatherLeggings = new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.LEGS) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.LEGS) {
                Double amount = Attribute.getAttributeWarmthAmount(0.14, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor leatherBoots = new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.FEET) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.FEET) {
                Double amount = Attribute.getAttributeWarmthAmount(0.08, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };

    private static ItemArmor chainHelmet = new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.HEAD) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.HEAD) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.1, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor chainChestplate = new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.CHEST) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.CHEST) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.16, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor chainLeggings = new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.LEGS) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.LEGS) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.14, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor chainBoots = new ItemArmor(ItemArmor.ArmorMaterial.CHAIN, 0, EntityEquipmentSlot.FEET) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.FEET) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.08, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };

    private static ItemArmor ironHelmet = new ItemArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.HEAD) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.1, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor ironChestplate = new ItemArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.CHEST) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.CHEST) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.16, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor ironLeggings = new ItemArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.LEGS) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.LEGS) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.14, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor ironBoots = new ItemArmor(ItemArmor.ArmorMaterial.IRON, 0, EntityEquipmentSlot.FEET) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.FEET) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.08, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };

    private static ItemArmor goldHelmet = new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.HEAD) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.HEAD) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.1, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor goldChestplate = new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.CHEST) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.CHEST) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.16, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor goldLeggings = new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.LEGS) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.LEGS) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.14, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor goldBoots = new ItemArmor(ItemArmor.ArmorMaterial.GOLD, 0, EntityEquipmentSlot.FEET) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.FEET) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.08, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };

    private static ItemArmor diamondHelmet = new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.HEAD) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.1, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor diamondChestplate = new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.CHEST) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.CHEST) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.16, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor diamondLeggings = new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.LEGS) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.LEGS) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.14, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };
    private static ItemArmor diamondBoots = new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.FEET) {
        @Override
        public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

            Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

            if (slot == EntityEquipmentSlot.FEET) {
                Double amount = Attribute.getAttributeWarmthAmount(-0.08, stack);
                multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                        "Tool Modifier", amount, 1));
            }
            return multimap;
        }
    };

    @SubscribeEvent
    public static void reRegisterItems(RegistryEvent.Register<Item> event) {
        leatherHelmet.setTranslationKey("helmetCloth");
        event.getRegistry().register(leatherHelmet.setRegistryName("minecraft:leather_helmet"));
        leatherChestplate.setTranslationKey("chestplateCloth");
        event.getRegistry().register(leatherChestplate.setRegistryName("minecraft:leather_chestplate"));
        leatherLeggings.setTranslationKey("leggingsCloth");
        event.getRegistry().register(leatherLeggings.setRegistryName("minecraft:leather_leggings"));
        leatherBoots.setTranslationKey("bootsCloth");
        event.getRegistry().register(leatherBoots.setRegistryName("minecraft:leather_boots"));

        chainHelmet.setTranslationKey("helmetChain");
        event.getRegistry().register(chainHelmet.setRegistryName("minecraft:chainmail_helmet"));
        chainChestplate.setTranslationKey("chestplateChain");
        event.getRegistry().register(chainChestplate.setRegistryName("minecraft:chainmail_chestplate"));
        chainLeggings.setTranslationKey("leggingsChain");
        event.getRegistry().register(chainLeggings.setRegistryName("minecraft:chainmail_leggings"));
        chainBoots.setTranslationKey("bootsChain");
        event.getRegistry().register(chainBoots.setRegistryName("minecraft:chainmail_boots"));

        ironHelmet.setTranslationKey("helmetIron");
        event.getRegistry().register(ironHelmet.setRegistryName("minecraft:iron_helmet"));
        ironChestplate.setTranslationKey("chestplateIron");
        event.getRegistry().register(ironChestplate.setRegistryName("minecraft:iron_chestplate"));
        ironLeggings.setTranslationKey("leggingsIron");
        event.getRegistry().register(ironLeggings.setRegistryName("minecraft:iron_leggings"));
        ironBoots.setTranslationKey("bootsIron");
        event.getRegistry().register(ironBoots.setRegistryName("minecraft:iron_boots"));

        goldHelmet.setTranslationKey("helmetGold");
        event.getRegistry().register(goldHelmet.setRegistryName("minecraft:golden_helmet"));
        goldChestplate.setTranslationKey("chestplateGold");
        event.getRegistry().register(goldChestplate.setRegistryName("minecraft:golden_chestplate"));
        goldLeggings.setTranslationKey("leggingsGold");
        event.getRegistry().register(goldLeggings.setRegistryName("minecraft:golden_leggings"));
        goldBoots.setTranslationKey("bootsGold");
        event.getRegistry().register(goldBoots.setRegistryName("minecraft:golden_boots"));

        diamondHelmet.setTranslationKey("helmetDiamond");
        event.getRegistry().register(diamondHelmet.setRegistryName("minecraft:diamond_helmet"));
        diamondChestplate.setTranslationKey("chestplateDiamond");
        event.getRegistry().register(diamondChestplate.setRegistryName("minecraft:diamond_Chestplate"));
        diamondLeggings.setTranslationKey("leggingsDiamond");
        event.getRegistry().register(diamondLeggings.setRegistryName("minecraft:diamond_leggings"));
        diamondBoots.setTranslationKey("bootsDiamond");
        event.getRegistry().register(diamondBoots.setRegistryName("minecraft:diamond_boots"));



    }





}
