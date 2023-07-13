package septem150.septemtweaks.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import septem150.septemtweaks.IRegisterable;
import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.Tags;

public class BlockAdamantiteOre extends Block implements IRegisterable {

  private static final String blockName = "oreAdamantite";

  public BlockAdamantiteOre() {
    super(Material.rock);
    this.setBlockName(String.format("%s.%s", Tags.MODID, blockName));
    this.setCreativeTab(SeptemCreativeTab.getInstance());
    this.setBlockTextureName(String.format("%s:%s", Tags.MODID, blockName));
    this.setHardness(3.0F);
    this.setResistance(5.0F);
  }

  @Override
  public void register() {
    GameRegistry.registerBlock(this, blockName);
  }

}
