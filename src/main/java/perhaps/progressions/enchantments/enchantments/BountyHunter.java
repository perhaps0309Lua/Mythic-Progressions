package perhaps.progressions.enchantments.enchantments;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import perhaps.progressions.MythicProgressions;
import perhaps.progressions.enchantments.EnchantmentRarity;
import perhaps.progressions.enchantments.Enchantments;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = MythicProgressions.MOD_ID)
public class BountyHunter extends Enchantment {
    public BountyHunter(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinCost(int level) { return EnchantmentRarity.RARE.getMinCost(level); }
    @Override
    public int getMaxCost(int level) { return EnchantmentRarity.RARE.getMaxCost(level); }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (!(event.getSource().getDirectEntity() instanceof Player player)) return;

        Level world = player.level;
        ItemStack heldItem = player.getMainHandItem();
        int level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.registeredEnchantments.get("bounty_hunter"), heldItem);
        if (level < 1 || world.isClientSide || heldItem.isEmpty() || world.getRandom().nextFloat() > (0.05f * level)) return;

        Collection<ItemEntity> entityDrops = event.getDrops();
        entityDrops.forEach((itemEntity -> {
            ItemStack drop = itemEntity.getItem();
            drop.setCount(drop.getCount() * 2);
        }));
    }
}