package perhaps.progressions.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import perhaps.progressions.MythicProgressions;
import perhaps.progressions.enchantments.enchantments.*;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MythicProgressions.MOD_ID)
public class Enchantments {
    @FunctionalInterface
    public interface EnchantmentCallback {
        void run(Enchantment.Rarity rarity, EnchantmentCategory category, EquipmentSlot[] equipmentSlots);
    }

    public static Map<String, Enchantment> registeredEnchantments = new HashMap<>();

    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MythicProgressions.MOD_ID);
    private static final Map<String, Map<String, Object>> enchantments = Map.ofEntries(
            Map.entry("auto_smelt", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.DIGGER,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) AutoSmelt::new
            )),
            Map.entry("smoke_mastery", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) SmokeMastery::new
            )),
            Map.entry("deep_miner", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.DIGGER,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) DeepMiner::new
            )),
            Map.entry("beheading", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) Beheading::new
            )),
            Map.entry("stone_breaker", Map.of(
                    "rarity", Enchantment.Rarity.UNCOMMON,
                    "category", EnchantmentCategory.DIGGER,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) StoneBreaker::new
            )),
            Map.entry("pyromania", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) Pyromania::new
            )),
            Map.entry("satiety", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) Satiety::new
            )),
            Map.entry("glimmering", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) Glimmering::new
            )),
            Map.entry("god_of_thunder", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND },
                    "callback", (EnchantmentCallback) GodOfThunder::new
            )),
            Map.entry("wisdom", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) Wisdom::new
            )),
            Map.entry("nocturnal", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) Nocturnal::new
            )),
            Map.entry("airborne", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) Airborne::new
            )),
            Map.entry("bounty_hunter", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) BountyHunter::new
            )),
            Map.entry("magnetism", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.WEAPON,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND },
                    "callback", (EnchantmentCallback) Magnetism::new
            )),
            Map.entry("sugar_rush", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) SugarRush::new
            )),
            Map.entry("nimble_feet", Map.of(
                    "rarity", Enchantment.Rarity.UNCOMMON,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) NimbleFeet::new
            )),
            Map.entry("ender_mind", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET },
                    "callback", (EnchantmentCallback) EnderMind::new
            )),
            Map.entry("paralysis", Map.of(
                    "rarity", Enchantment.Rarity.RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND },
                    "callback", (EnchantmentCallback) Paralysis::new
            )),
            Map.entry("atomic_resistance", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.CHEST },
                    "callback", (EnchantmentCallback) AtomicResistance::new
            )),
            Map.entry("lifestealer", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.CHEST },
                    "callback", (EnchantmentCallback) Lifestealer::new
            )),
            Map.entry("blazing_aura", Map.of(
                    "rarity", Enchantment.Rarity.VERY_RARE,
                    "category", EnchantmentCategory.ARMOR,
                    "equipmentSlot", new EquipmentSlot[] { EquipmentSlot.CHEST },
                    "callback", (EnchantmentCallback) BlazingAura::new
            ))
    );


    public static void initializeEnchantments(IEventBus eventBus) {
        enchantments.forEach((enchantmentName, enchantmentObject) -> {
            Enchantment.Rarity rarity = (Enchantment.Rarity) enchantmentObject.get("rarity");
            EnchantmentCategory category = (EnchantmentCategory) enchantmentObject.get("category");
            EquipmentSlot[] equipmentSlots = (EquipmentSlot[]) enchantmentObject.get("equipmentSlot");
            EnchantmentCallback callback = (EnchantmentCallback) enchantmentObject.get("callback");

            addEnchantment(enchantmentName, rarity, category, equipmentSlots, callback);
        });

        ENCHANTMENTS.register(eventBus);
    }

    public static void addEnchantment(String enchantmentName, Enchantment.Rarity rarity, EnchantmentCategory category, EquipmentSlot[] equipmentSlots, EnchantmentCallback callback) {
        ENCHANTMENTS.register(enchantmentName, () -> {
            callback.run(rarity, category, equipmentSlots);
            Enchantment dummyEnchantment = new Enchantment(rarity, category, equipmentSlots) {
                // This is a dummy class to prevent Minecraft from crashing
                // Everything should be handled from callback
            };

            registeredEnchantments.put(enchantmentName, dummyEnchantment);
            return dummyEnchantment;
        });
    }
}
