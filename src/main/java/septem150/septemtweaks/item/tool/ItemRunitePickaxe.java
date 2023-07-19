package septem150.septemtweaks.item.tool;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntryPickaxe;
import septem150.septemtweaks.material.MaterialRunite;

public class ItemRunitePickaxe extends EntryPickaxe {

    public ItemRunitePickaxe(CreativeTabs creativeTab) {
        super("runite_pickaxe", MaterialRunite.toolMaterial, creativeTab);
    }

    public ItemRunitePickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
