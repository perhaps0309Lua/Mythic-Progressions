package perhaps.progressions.enchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import perhaps.progressions.MythicProgressions;
import perhaps.progressions.enchantments.EnchantmentRarity;
import perhaps.progressions.enchantments.Enchantments;

@Mod.EventBusSubscriber(modid = MythicProgressions.MOD_ID)
public class DeepMiner extends Enchantment {
    public DeepMiner(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinCost(int level) {
        return EnchantmentRarity.RARE.getMinCost(level);
    }

    @Override
    public int getMaxCost(int level) {
        return EnchantmentRarity.RARE.getMaxCost(level);
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getPlayer();
        if (player.getY() > 32) return;

        Level world = player.level;
        ItemStack heldItem = player.getMainHandItem();
        int level = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.registeredEnchantments.get("deep_miner"), heldItem);
        if (level < 1 || world.isClientSide || heldItem.isEmpty()) return;

        event.setNewSpeed(event.getOriginalSpeed() + (1.25f * level));
    }
}
