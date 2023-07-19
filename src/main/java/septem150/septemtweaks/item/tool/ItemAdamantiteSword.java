package septem150.septemtweaks.item.tool;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntrySword;
import septem150.septemtweaks.material.MaterialAdamantite;

public class ItemAdamantiteSword extends EntrySword {

    public ItemAdamantiteSword(CreativeTabs creativeTab) {
        super("adamantite_sword", MaterialAdamantite.toolMaterial, creativeTab);
    }

    public ItemAdamantiteSword() {
        this(SeptemCreativeTab.getInstance());
    }

}
