package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntryItem;

public class ItemElectrumCoil extends EntryItem {

    public ItemElectrumCoil(CreativeTabs creativeTab) {
        super("electrum_coil", creativeTab);
    }

    public ItemElectrumCoil() {
        this(SeptemCreativeTab.getInstance());
    }

}
