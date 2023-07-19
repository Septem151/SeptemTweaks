package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialRunite;

public class BlockRuniteBlock extends EntryBlock {

    public BlockRuniteBlock(CreativeTabs creativeTab) {
        super("runite_block", MaterialRunite.blockMaterial, creativeTab);
        this.setHardness(4.5F);
        this.setResistance(6.5F);
    }

    public BlockRuniteBlock() {
        this(null);
    }

}
