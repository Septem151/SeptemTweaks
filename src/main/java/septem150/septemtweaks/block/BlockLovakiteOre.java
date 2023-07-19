package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialLovakite;

public class BlockLovakiteOre extends EntryBlock {

    public BlockLovakiteOre(CreativeTabs creativeTab) {
        super("lovakite_ore", MaterialLovakite.oreMaterial, creativeTab);
        this.setHardness(4.0F);
        this.setResistance(8.0F);
    }

    public BlockLovakiteOre() {
        this(null);
    }

}
