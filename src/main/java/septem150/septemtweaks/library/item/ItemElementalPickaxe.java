package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialElemental;

public class ItemElementalPickaxe extends EntryPickaxe {

    public ItemElementalPickaxe(CreativeTabs creativeTab) {
        super("elemental_pickaxe", MaterialElemental.toolMaterial, creativeTab);
    }

    public ItemElementalPickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
