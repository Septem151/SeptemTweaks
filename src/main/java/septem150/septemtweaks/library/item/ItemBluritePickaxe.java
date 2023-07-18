package septem150.septemtweaks.library.item;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.item.tool.EntryPickaxe;
import septem150.septemtweaks.library.material.MaterialBlurite;

public class ItemBluritePickaxe extends EntryPickaxe {

    public ItemBluritePickaxe(CreativeTabs creativeTab) {
        super("blurite_pickaxe", MaterialBlurite.toolMaterial, creativeTab);
    }

    public ItemBluritePickaxe() {
        this(SeptemCreativeTab.getInstance());
    }
}
