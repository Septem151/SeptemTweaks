package septem150.septemtweaks.item.tool;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntryPickaxe;
import septem150.septemtweaks.material.MaterialLovakite;

public class ItemLovakitePickaxe extends EntryPickaxe {

    public ItemLovakitePickaxe(CreativeTabs creativeTab) {
        super("lovakite_pickaxe", MaterialLovakite.toolMaterial, creativeTab);
    }

    public ItemLovakitePickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
