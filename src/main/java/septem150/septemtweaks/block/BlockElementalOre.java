package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialElemental;

public class BlockElementalOre extends EntryBlock {

    public BlockElementalOre(CreativeTabs creativeTab) {
        super("elemental_ore", MaterialElemental.oreMaterial, creativeTab);
        this.setHardness(0.5F);
        this.setResistance(15.0F);
    }

    public BlockElementalOre() {
        this(null);
    }

}
