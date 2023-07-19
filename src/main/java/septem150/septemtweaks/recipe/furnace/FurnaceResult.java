package septem150.septemtweaks.recipe.furnace;

import net.minecraft.item.ItemStack;

import septem150.septemtweaks.util.ItemWrapper;

public class FurnaceResult {

    private final ItemStack result;
    private final float exp;

    public FurnaceResult(ItemStack result, float exp) {
        this.result = result;
        this.exp = exp;
    }

    public FurnaceResult(ItemWrapper result, float exp) {
        this(result.itemStack, exp);
    }

    public ItemStack getResult() {
        return this.result;
    }

    public float getExp() {
        return this.exp;
    }
}
