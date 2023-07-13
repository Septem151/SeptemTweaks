package septem150.septemtweaks.item;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.Tags;

public abstract class SeptemItem extends Item {

    protected final String itemName;

    public SeptemItem(String itemName) {
        this.itemName = itemName;
        this.setUnlocalizedName(String.format("%s.%s", Tags.MODID, this.itemName));
        this.setCreativeTab(SeptemCreativeTab.getInstance());
    }

    public String getItemName() {
        return this.itemName;
    }

    public void register() {
        GameRegistry.registerItem(this, itemName);
    }

}
