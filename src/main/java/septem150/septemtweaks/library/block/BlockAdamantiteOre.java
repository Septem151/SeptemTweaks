package septem150.septemtweaks.library.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.library.definition.EntryBlock;
import septem150.septemtweaks.library.material.MaterialAdamantite;

public class BlockAdamantiteOre extends EntryBlock {

    public BlockAdamantiteOre(CreativeTabs creativeTab) {
        super("adamantite_ore", MaterialAdamantite.material, creativeTab);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    public BlockAdamantiteOre() {
        this(null);
    }

}
