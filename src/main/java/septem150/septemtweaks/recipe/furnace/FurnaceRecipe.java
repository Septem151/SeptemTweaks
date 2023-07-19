package septem150.septemtweaks.recipe.furnace;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;

import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;

public class FurnaceRecipe {

    private final List<ItemStack> inputs;
    private final FurnaceResult furnaceResult;

    public FurnaceRecipe(List<ItemWrapper> inputs, FurnaceResult result) {
        this.inputs = inputs.stream()
            .map(itemWrapper -> itemWrapper.itemStack)
            .collect(Collectors.toList());
        this.furnaceResult = result;
    }

    public FurnaceRecipe(String oreDict, ItemWrapper result, float exp) {
        this.inputs = ItemHelper.getOreDictItems(oreDict);
        this.furnaceResult = new FurnaceResult(result, exp);
    }

    public FurnaceRecipe(ItemWrapper input, ItemWrapper result, float exp) {
        this.inputs = Arrays.asList(input.itemStack);
        this.furnaceResult = new FurnaceResult(result, exp);
    }

    public FurnaceRecipe(List<ItemWrapper> inputs, ItemWrapper result, float exp) {
        this.inputs = inputs.stream()
            .map(itemWrapper -> itemWrapper.itemStack)
            .collect(Collectors.toList());
        this.furnaceResult = new FurnaceResult(result, exp);
    }

    public List<ItemStack> getInputs() {
        return this.inputs;
    }

    public FurnaceResult getFurnaceResult() {
        return this.furnaceResult;
    }

    public ItemStack getResult() {
        return furnaceResult.getResult();
    }

    public float getExp() {
        return furnaceResult.getExp();
    }
}
