package septem150.septemtweaks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.Tags;

public abstract class SeptemBlock extends Block {

    protected final String blockName;

    protected SeptemBlock(Material material, String blockName) {
        super(material);
        this.blockName = blockName;
        this.setBlockName(String.format("%s.%s", Tags.MODID, this.blockName));
        this.setCreativeTab(SeptemCreativeTab.getInstance());
    }

    public String getBlockName() {
        return this.blockName;
    }

    public Block register() {
        return GameRegistry.registerBlock(this, blockName);
    }

}
