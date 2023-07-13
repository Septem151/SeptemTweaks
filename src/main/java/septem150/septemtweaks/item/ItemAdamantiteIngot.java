package septem150.septemtweaks.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import septem150.septemtweaks.IRegisterable;
import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.Tags;

public class ItemAdamantiteIngot extends Item implements IRegisterable {

  private static final String itemName = "ingotAdamantite";

  public ItemAdamantiteIngot() {
    super();
    this.setTextureName(String.format("%s:%s", Tags.MODID, itemName));
    this.setUnlocalizedName(String.format("%s.%s", Tags.MODID, itemName));
    this.setCreativeTab(SeptemCreativeTab.getInstance());
  }

  @Override
  public void register() {
    GameRegistry.registerItem(this, itemName);
  }
}
