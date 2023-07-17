package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialRunite;

public class ItemRunitePickaxe extends EntryPickaxe {

    public ItemRunitePickaxe(CreativeTabs creativeTab) {
        super("runite_pickaxe", MaterialRunite.toolMaterial, creativeTab);
    }

    public ItemRunitePickaxe() {
        this(null);
    }
}
