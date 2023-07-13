package septem150.septemtweaks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import septem150.septemtweaks.block.BlockAdamantiteOre;
import septem150.septemtweaks.item.ItemAdamantiteIngot;
import septem150.septemtweaks.item.tool.ItemAdamantitePickaxe;
import septem150.septemtweaks.item.tool.ItemAdamantiteSword;

public class Registrar {
  private static Registrar instance;
  private final List<IRegisterable> regList = new ArrayList<>();

  public static final BlockAdamantiteOre blockAdamantiteOre = new BlockAdamantiteOre();
  public static final ItemAdamantiteIngot itemAdamantiteIngot = new ItemAdamantiteIngot();
  public static final ItemAdamantitePickaxe pickaxeAdamantite = new ItemAdamantitePickaxe();
  public static final ItemAdamantiteSword swordAdamantite = new ItemAdamantiteSword();

  private Registrar() {
    Collections.addAll(this.regList,
        blockAdamantiteOre,
        itemAdamantiteIngot,
        pickaxeAdamantite,
        swordAdamantite);
  }

  public static Registrar getInstance() {
    if (instance == null) {
      instance = new Registrar();
    }
    return instance;
  }

  public void registerAll() {
    regList.forEach(elem -> elem.register());
  }

}
