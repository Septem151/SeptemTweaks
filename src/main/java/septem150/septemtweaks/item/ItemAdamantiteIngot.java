package septem150.septemtweaks.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemAdamantiteIngot extends EntryItem {

    public ItemAdamantiteIngot(CreativeTabs creativeTab) {
        super("adamantite_ingot", creativeTab);
    }

    public ItemAdamantiteIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
