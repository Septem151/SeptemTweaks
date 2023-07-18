package septem150.septemtweaks.library.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.library.material.MaterialAdamantite;

public class BlockAdamantiteBlock extends EntryBlock {

    public BlockAdamantiteBlock(CreativeTabs creativeTab) {
        super("adamantite_block", MaterialAdamantite.blockMaterial, creativeTab);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    public BlockAdamantiteBlock() {
        this(null);
    }

}
