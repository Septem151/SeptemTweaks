package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialBlurite;

public class BlockBluriteOre extends EntryBlock {

    public BlockBluriteOre(CreativeTabs creativeTab) {
        super("blurite_ore", MaterialBlurite.oreMaterial, creativeTab);
        this.setHardness(1.5F);
        this.setResistance(5.0F);
    }

    public BlockBluriteOre() {
        this(null);
    }

}
