package septem150.septemtweaks.item.tool;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemSword;
import septem150.septemtweaks.IRegisterable;
import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.Tags;

public class ItemAdamantiteSword extends ItemSword implements IRegisterable {

  private static final String itemName = "swordAdamantite";

  public ItemAdamantiteSword() {
    super(ToolMaterial.IRON);
    this.setCreativeTab(SeptemCreativeTab.getInstance());
    this.setUnlocalizedName(String.format("%s.%s", Tags.MODID, itemName));
    this.setTextureName(String.format("%s:%s", Tags.MODID, itemName));
  }

  @Override
  public void register() {
    GameRegistry.registerItem(this, itemName);
  }

}
