package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialLovakite;

public class BlockLovakiteBlock extends EntryBlock {

    public BlockLovakiteBlock(CreativeTabs creativeTab) {
        super("lovakite_block", MaterialLovakite.blockMaterial, creativeTab);
        this.setHardness(4.0F);
        this.setResistance(8.0F);
    }

    public BlockLovakiteBlock() {
        this(null);
    }

}
