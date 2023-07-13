package septem150.septemtweaks.block;

import net.minecraft.block.material.Material;

import septem150.septemtweaks.Tags;

public class BlockAdamantiteOre extends SeptemBlock {

    public BlockAdamantiteOre() {
        super(Material.rock, "oreAdamantite");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setBlockTextureName(String.format("%s:%s", Tags.MODID, this.blockName));
    }

}
