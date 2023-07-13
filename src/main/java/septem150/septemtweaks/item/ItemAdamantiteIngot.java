/**
 * 
 */
package septem150.septemtweaks.item;

import septem150.septemtweaks.Tags;

public class ItemAdamantiteIngot extends SeptemItem {

    public ItemAdamantiteIngot() {
        super("ingotAdamantite");
        this.setTextureName(String.format("%s:%s", Tags.MODID, this.itemName));
    }
}
