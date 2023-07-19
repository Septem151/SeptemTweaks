package septem150.septemtweaks.recipe.furnace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;

public class FurnaceManager {

    private final Set<ItemStack> whitelistedInputs;
    private final Set<String> whitelistedMods;
    private final Map<ItemStack, FurnaceResult> additionalRecipes;

    private static FurnaceManager instance;

    private FurnaceManager() {
        this.whitelistedInputs = new HashSet<>();
        this.whitelistedMods = new HashSet<>();
        this.additionalRecipes = new HashMap<>();

    }

    public static FurnaceManager getInstance() {
        if (instance == null) {
            FurnaceManager.instance = new FurnaceManager();
        }
        return FurnaceManager.instance;
    }

    public void addRecipe(FurnaceRecipe recipe) {
        for (ItemStack input : recipe.getInputs()) {
            this.additionalRecipes.put(input, recipe.getFurnaceResult());
        }
    }

    public void addWhitelistedInput(ItemWrapper input) {
        this.whitelistedInputs.add(input.itemStack);
    }

    public void addWhitelistedInputs(ItemWrapper... inputs) {
        for (ItemWrapper input : inputs) {
            this.addWhitelistedInput(input);
        }
    }

    public void addWhitelistedInputs(List<ItemWrapper> inputs) {
        this.addWhitelistedInputs(inputs.toArray(new ItemWrapper[0]));
    }

    public void addWhitelistedMod(String modId) {
        this.whitelistedMods.add(modId);
    }

    public void addWhitelistedMods(String... mods) {
        for (String mod : mods) {
            this.addWhitelistedMod(mod);
        }
    }

    public void registerRecipes() {
        Map<ItemStack, ItemStack> recipes = FurnaceRecipes.smelting()
            .getSmeltingList();
        for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = recipes.entrySet()
            .iterator(); entries.hasNext();) {
            Map.Entry<ItemStack, ItemStack> recipe = entries.next();
            ItemStack input = recipe.getKey();

            if (this.isInputWhitelisted(input)) {
                continue;
            }

            entries.remove();
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Furnace Recipe removed for %s",
                    ItemHelper.getItemFriendlyName(new ItemWrapper(input))));
        }
        for (Map.Entry<ItemStack, FurnaceResult> recipe : this.additionalRecipes.entrySet()) {
            ItemStack input = recipe.getKey();
            FurnaceResult furnaceResult = recipe.getValue();
            GameRegistry.addSmelting(input, furnaceResult.getResult(), furnaceResult.getExp());
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Furnace Recipe added for %s",
                    ItemHelper.getItemFriendlyName(new ItemWrapper(input))));
        }
    }

    private boolean isInputWhitelistedByMods(ItemStack input) {
        for (String mod : this.whitelistedMods) {
            if (ItemHelper.isItemFromMod(new ItemWrapper(input), mod)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInputWhitelisted(ItemStack input) {
        if (isInputWhitelistedByMods(input)) {
            return true;
        }
        for (ItemStack item : this.whitelistedInputs) {
            if (ItemHelper.areItemsEqual(new ItemWrapper(input), new ItemWrapper(item))) {
                return true;
            }
        }
        return false;
    }
}
