package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialAdamantite;

public class ItemAdamantitePickaxe extends EntryPickaxe {

    public ItemAdamantitePickaxe(CreativeTabs creativeTab) {
        super("adamantite_pickaxe", MaterialAdamantite.toolMaterial, creativeTab);
    }

    public ItemAdamantitePickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
