package septem150.septemtweaks.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;
import septem150.septemtweaks.SeptemTweaks;

public class ItemHelper {

    public static UniqueIdentifier getItemInfo(ItemWrapper itemWrapper) {
        return GameRegistry.findUniqueIdentifierFor(itemWrapper.itemStack.getItem());
    }

    public static boolean isItemFromMod(ItemWrapper itemWrapper, String modId) {
        return ItemHelper.getItemInfo(itemWrapper).modId.equals(modId);
    }

    public static String getItemFriendlyName(ItemWrapper itemWrapper) {
        UniqueIdentifier info = ItemHelper.getItemInfo(itemWrapper);
        return String.format("%s:%s:%d", info.modId, info.name, itemWrapper.itemStack.getItemDamage());
    }

    public static boolean areItemsEqual(ItemWrapper target, ItemWrapper other, boolean strict) {
        return OreDictionary.itemMatches(target.itemStack, other.itemStack, strict);
    }

    public static boolean areItemsEqual(ItemWrapper target, ItemWrapper other) {
        return ItemHelper.areItemsEqual(target, other, false);
    }

    public static List<ItemStack> getOreDictItems(String oreDict) {
        return OreDictionary.getOres(oreDict);
    }

    public static boolean isItemInOreDict(ItemWrapper itemWrapper, String oreDict) {
        List<ItemStack> oreDictItems = ItemHelper.getOreDictItems(oreDict);
        for (ItemStack oreDictItem : oreDictItems) {
            if (ItemHelper.areItemsEqual(new ItemWrapper(oreDictItem), itemWrapper)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getItemOreDicts(ItemWrapper itemWrapper) {
        List<String> itemOreDicts = new ArrayList<>();
        String[] allOreDicts = OreDictionary.getOreNames();
        for (String oreDict : allOreDicts) {
            if (ItemHelper.isItemInOreDict(itemWrapper, oreDict)) {
                itemOreDicts.add(oreDict);
            }
        }
        return itemOreDicts;
    }

    public static ItemWrapper getMultipleItems(String modId, String name, int stackSize, int meta) {
        ItemStack item = GameRegistry.findItemStack(modId, name, stackSize);
        item.setItemDamage(meta);
        return new ItemWrapper(item);
    }

    public static ItemWrapper getMultipleItems(String modId, String name, int stackSize) {
        return new ItemWrapper(GameRegistry.findItemStack(modId, name, stackSize));
    }

    public static ItemWrapper getItem(String modId, String name, int meta) {
        return ItemHelper.getMultipleItems(modId, name, 1, meta);
    }

    public static ItemWrapper getItem(String modId, String name) {
        return ItemHelper.getItem(modId, name, 0);
    }

    public static List<ItemWrapper> getItemsMetaRange(String modId, String name, int startMeta, int endMeta) {
        List<ItemWrapper> items = new ArrayList<>();
        for (int meta = startMeta; meta <= endMeta; meta++) {
            items.add(ItemHelper.getItem(modId, name, meta));
        }
        return items;
    }

    public static ItemWrapper fromFriendlyName(String friendlyName) {
        String[] parts = friendlyName.split(":");
        if (parts.length < 2) {
            SeptemTweaks.LOG
                .error(String.format("[SeptemTweaks]: Malformed friendlyName %s could not be parsed!", friendlyName));
            return null;
        }
        String modId = parts[0];
        String name = parts[1];
        if (parts.length > 2) {
            int meta = Integer.valueOf(parts[2]);
            return ItemHelper.getItem(modId, name, meta);
        } else {
            return ItemHelper.getItem(modId, name);
        }
    }
}
