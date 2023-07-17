package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntryItem;

public class ItemAdamantiteIngot extends EntryItem {

    public ItemAdamantiteIngot(CreativeTabs creativeTab) {
        super("adamantite_ingot", creativeTab);
    }

    public ItemAdamantiteIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
