package septem150.septemtweaks.api.crafting;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {

    public static void addShapedRecipe(ItemStack result, Object... recipe) {
        GameRegistry.addRecipe(new ShapedOreRecipe(result, recipe));
    }

    public static void addShapedRecipe(Item result, Object... recipe) {
        RecipeHelper.addShapedRecipe(new ItemStack(result), recipe);
    }

    public static void addShapedRecipe(Block result, Object... recipe) {
        RecipeHelper.addShapedRecipe(new ItemStack(result), recipe);
    }

    public static void addShapelessRecipe(ItemStack result, Object... recipe) {
        GameRegistry.addRecipe(new ShapelessOreRecipe(result, recipe));
    }

    public static void addShapelessRecipe(Item result, Object... recipe) {
        RecipeHelper.addShapelessRecipe(new ItemStack(result), recipe);
    }

    public static void addShapelessRecipe(Block result, Object... recipe) {
        RecipeHelper.addShapelessRecipe(new ItemStack(result), recipe);
    }

    public static void addFurnaceRecipe(ItemStack input, ItemStack output, float exp) {
        GameRegistry.addSmelting(input, output, exp);
    }

    public static void addFurnaceRecipe(Item input, ItemStack output, float exp) {
        GameRegistry.addSmelting(new ItemStack(input), output, exp);
    }

    public static void addFurnaceRecipe(Block input, ItemStack output, float exp) {
        GameRegistry.addSmelting(new ItemStack(input), output, exp);
    }

    public static void addFurnaceRecipe(String input, ItemStack output, float exp) {
        List<ItemStack> oreDict = OreDictionary.getOres(input);
        oreDict.forEach(ore -> RecipeHelper.addFurnaceRecipe(ore, output, exp));
    }
}
