package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemRuniteIngot extends EntryItem {

    public ItemRuniteIngot(CreativeTabs creativeTab) {
        super("runite_ingot", creativeTab);
    }

    public ItemRuniteIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
