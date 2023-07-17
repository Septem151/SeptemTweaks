package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryItem;

public class ItemElementalIngot extends EntryItem {

    public ItemElementalIngot(CreativeTabs creativeTab) {
        super("elemental_ingot", creativeTab);
    }

    public ItemElementalIngot() {
        this(null);
    }
}
