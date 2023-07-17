package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntrySword;
import septem150.septemtweaks.library.material.MaterialAdamantite;

public class ItemAdamantiteSword extends EntrySword {

    public ItemAdamantiteSword(CreativeTabs creativeTab) {
        super("adamantite_sword", MaterialAdamantite.toolMaterial, creativeTab);
    }

    public ItemAdamantiteSword() {
        this(SeptemCreativeTab.getInstance());
    }

}
