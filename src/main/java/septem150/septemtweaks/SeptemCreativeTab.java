package septem150.septemtweaks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import septem150.septemtweaks.library.catalog.STItems;

public class SeptemCreativeTab extends CreativeTabs {

    private static SeptemCreativeTab instance;

    private SeptemCreativeTab() {
        super("SeptemTweaks");
    }

    public static SeptemCreativeTab getInstance() {
        if (instance == null) {
            instance = new SeptemCreativeTab();
        }
        return instance;
    }

    @Override
    public Item getTabIconItem() {
        return new ItemStack(STItems.adamantitePickaxe).getItem();
    }

}
