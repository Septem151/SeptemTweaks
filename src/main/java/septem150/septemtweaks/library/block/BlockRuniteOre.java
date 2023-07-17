package septem150.septemtweaks.library.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryBlock;
import septem150.septemtweaks.library.material.MaterialRunite;

public class BlockRuniteOre extends EntryBlock {

    public BlockRuniteOre(CreativeTabs creativeTab) {
        super("runite_ore", MaterialRunite.oreMaterial, creativeTab);
        this.setHardness(4.5F);
        this.setResistance(6.5F);
    }

    public BlockRuniteOre() {
        this(null);
    }

}
