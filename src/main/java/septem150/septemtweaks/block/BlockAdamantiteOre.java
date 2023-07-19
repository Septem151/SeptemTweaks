package septem150.septemtweaks.block;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.api.block.EntryBlock;
import septem150.septemtweaks.material.MaterialAdamantite;

public class BlockAdamantiteOre extends EntryBlock {

    public BlockAdamantiteOre(CreativeTabs creativeTab) {
        super("adamantite_ore", MaterialAdamantite.oreMaterial, creativeTab);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    public BlockAdamantiteOre() {
        this(null);
    }

}
