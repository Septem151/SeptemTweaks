package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntryItem;

public class ItemLovakiteIngot extends EntryItem {

    public ItemLovakiteIngot(CreativeTabs creativeTab) {
        super("lovakite_ingot", creativeTab);
    }

    public ItemLovakiteIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
