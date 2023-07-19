package septem150.septemtweaks.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemBluriteIngot extends EntryItem {

    public ItemBluriteIngot(CreativeTabs creativeTab) {
        super("blurite_ingot", creativeTab);
    }

    public ItemBluriteIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
