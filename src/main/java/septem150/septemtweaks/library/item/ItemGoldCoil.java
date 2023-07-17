package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntryItem;

public class ItemGoldCoil extends EntryItem {

    public ItemGoldCoil(CreativeTabs creativeTab) {
        super("gold_coil", creativeTab);
    }

    public ItemGoldCoil() {
        this(SeptemCreativeTab.getInstance());
    }

}
