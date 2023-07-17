package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialBlurite;

public class ItemBluritePickaxe extends EntryPickaxe {

    public ItemBluritePickaxe(CreativeTabs creativeTab) {
        super("blurite_pickaxe", MaterialBlurite.toolMaterial, creativeTab);
    }

    public ItemBluritePickaxe() {
        this(null);
    }
}