package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialLovakite;

public class ItemLovakitePickaxe extends EntryPickaxe {

    public ItemLovakitePickaxe(CreativeTabs creativeTab) {
        super("lovakite_pickaxe", MaterialLovakite.toolMaterial, creativeTab);
    }

    public ItemLovakitePickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
