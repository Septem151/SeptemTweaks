package septem150.septemtweaks.library.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryBlock;
import septem150.septemtweaks.library.material.MaterialElemental;

public class BlockElementalBlock extends EntryBlock {

    public BlockElementalBlock(CreativeTabs creativeTab) {
        super("elemental_block", MaterialElemental.blockMaterial, creativeTab);
        this.setHardness(0.5F);
        this.setResistance(15.0F);
    }

    public BlockElementalBlock() {
        this(null);
    }

}
