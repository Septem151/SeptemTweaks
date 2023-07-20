package septem150.septemtweaks.recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;

public class CraftManager {

    private final Set<String> blacklistedMods;
    private final Set<ItemStack> blacklistedModResults;
    private final Set<ItemStack> blacklistedResults;
    private final List<IRecipe> additionalRecipes;

    private static CraftManager instance;

    private CraftManager() {
        this.blacklistedMods = new HashSet<>();
        this.blacklistedModResults = new HashSet<>();
        this.blacklistedResults = new HashSet<>();
        this.additionalRecipes = new ArrayList<>();
    }

    public static CraftManager getInstance() {
        if (CraftManager.instance == null) {
            CraftManager.instance = new CraftManager();
        }
        return CraftManager.instance;
    }

    public void replaceRecipes(ItemWrapper result, Object... recipe) {
        this.addBlacklistedResult(result);
        this.addRecipe(result, recipe);
    }

    public void addRecipe(ItemWrapper result, Object... recipe) {
        this.additionalRecipes.add(new ShapedOreRecipe(result.itemStack, recipe));
    }

    public void addShapelessRecipe(ItemWrapper result, Object... recipe) {
        this.additionalRecipes.add(new ShapelessOreRecipe(result.itemStack, recipe));
    }

    public void addRecipe(IRecipe recipe) {
        this.additionalRecipes.add(recipe);
    }

    public void addBlacklistedMod(String modId) {
        this.blacklistedMods.add(modId);
    }

    public void addBlacklistedResult(ItemWrapper result) {
        this.blacklistedResults.add(result.itemStack);
    }

    public void addBlacklistedResults(ItemWrapper... results) {
        for (ItemWrapper result : results) {
            this.addBlacklistedResult(result);
        }
    }

    public void addBlacklistedResults(List<ItemWrapper> results) {
        this.addBlacklistedResults(results.toArray(new ItemWrapper[0]));
    }

    public void registerRecipes() {
        for (Iterator<IRecipe> recipes = CraftingManager.getInstance()
            .getRecipeList()
            .iterator(); recipes.hasNext();) {
            IRecipe recipe = recipes.next();
            ItemStack result = recipe.getRecipeOutput();
            if (this.isResultBlacklisted(result)) {
                recipes.remove();
                SeptemTweaks.LOG.info(
                    String.format(
                        "[SeptemTweaks]: Crafting Recipe removed for %s",
                        ItemHelper.getItemFriendlyName(new ItemWrapper(result))));
            }
        }
        for (IRecipe recipe : additionalRecipes) {
            GameRegistry.addRecipe(recipe);
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Crafting Recipe added for %s",
                    ItemHelper.getItemFriendlyName(new ItemWrapper(recipe.getRecipeOutput()))));

        }
        this.blacklistedModResults.clear();
    }

    private boolean isResultBlacklistedByMods(ItemStack result) {
        if (this.blacklistedModResults.contains(result)) {
            return true;
        }
        for (String mod : this.blacklistedMods) {
            if (ItemHelper.isItemFromMod(new ItemWrapper(result), mod)) {
                this.blacklistedModResults.add(result);
                return true;
            }
        }
        return false;
    }

    private boolean isResultBlacklisted(ItemStack result) {
        if (this.isResultBlacklistedByMods(result)) {
            return true;
        }
        for (ItemStack item : this.blacklistedResults) {
            if (ItemHelper.areItemsEqual(new ItemWrapper(result), new ItemWrapper(item))) {
                return true;
            }
        }
        return false;
    }
}
