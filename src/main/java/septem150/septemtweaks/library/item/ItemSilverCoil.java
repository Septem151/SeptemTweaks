package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemSilverCoil extends EntryItem {

    public ItemSilverCoil(CreativeTabs creativeTab) {
        super("silver_coil", creativeTab);
    }

    public ItemSilverCoil() {
        this(SeptemCreativeTab.getInstance());
    }

}
