package septem150.septemtweaks.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.EntryItem;

public class ItemGlassFrame extends EntryItem {

    public ItemGlassFrame(CreativeTabs creativeTab) {
        super("glass_frame", creativeTab);
    }

    public ItemGlassFrame() {
        this(SeptemCreativeTab.getInstance());
    }

}
