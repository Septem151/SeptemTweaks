package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialBlurite;

public class BlockBluriteBlock extends EntryBlock {

    public BlockBluriteBlock(CreativeTabs creativeTab) {
        super("blurite_block", MaterialBlurite.blockMaterial, creativeTab);
        this.setHardness(1.5F);
        this.setResistance(5.0F);
    }

    public BlockBluriteBlock() {
        this(null);
    }

}
