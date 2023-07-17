package septem150.septemtweaks.library.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryBlock;
import septem150.septemtweaks.library.material.MaterialBlurite;

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