package septem150.septemtweaks.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemElementalIngot extends EntryItem {

    public ItemElementalIngot(CreativeTabs creativeTab) {
        super("elemental_ingot", creativeTab);
    }

    public ItemElementalIngot() {
        this(SeptemCreativeTab.getInstance());
    }
}
