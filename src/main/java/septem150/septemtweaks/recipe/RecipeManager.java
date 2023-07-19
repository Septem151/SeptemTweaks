package septem150.septemtweaks.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import septem150.septemtweaks.item.STItems;
import septem150.septemtweaks.recipe.furnace.FurnaceManager;
import septem150.septemtweaks.recipe.furnace.FurnaceRecipe;
import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;

public class RecipeManager {

    private final FurnaceManager furnaceManager;
    private final CraftManager craftManager;

    private static RecipeManager instance;

    private RecipeManager() {
        this.furnaceManager = FurnaceManager.getInstance();
        this.craftManager = CraftManager.getInstance();
    }

    public static RecipeManager getInstance() {
        if (instance == null) {
            instance = new RecipeManager();
        }
        return instance;
    }

    public void initRecipes() {
        // FURNACE MODS WHITELIST
        this.furnaceManager.addWhitelistedMods("harvestcraft", "claybucket");

        // FURNACE VANILLA WHITELIST
        this.furnaceManager.addWhitelistedInputs(
            new ItemWrapper(Blocks.cobblestone),
            new ItemWrapper(Blocks.stone),
            new ItemWrapper(Blocks.sand),
            new ItemWrapper(Blocks.log),
            new ItemWrapper(Blocks.log2),
            new ItemWrapper(Blocks.cactus),
            new ItemWrapper(Blocks.stonebrick),
            new ItemWrapper(Blocks.gravel),
            new ItemWrapper(Blocks.brown_mushroom),
            new ItemWrapper(Blocks.clay),
            new ItemWrapper(Blocks.red_mushroom),
            new ItemWrapper(Items.pumpkin_seeds),
            new ItemWrapper(Items.clay_ball),
            new ItemWrapper(Items.bread),
            new ItemWrapper(Items.sugar),
            new ItemWrapper(Items.beef),
            new ItemWrapper(Items.chicken),
            new ItemWrapper(Items.porkchop),
            new ItemWrapper(Items.potato),
            new ItemWrapper(Items.fish),
            new ItemWrapper(Items.fish, 1));

        // FURNACE TCONSTRUCT WHITELIST
        List<String> tcFurnaceItems = new ArrayList<>();
        Collections.addAll(tcFurnaceItems, "CraftedSoil:6", "materials:36", "SpeedBlock");
        tcFurnaceItems.forEach(
            itemName -> this.furnaceManager
                .addWhitelistedInput(ItemHelper.fromFriendlyName(String.format("TConstruct:%s", itemName))));
        this.furnaceManager.addWhitelistedInputs(ItemHelper.getItemsMetaRange("TConstruct", "CraftedSoil", 0, 3));

        // FURNACE MINEFACTORY RELOADED WHITELIST
        List<String> mfrFurnaceItems = new ArrayList<>();
        Collections.addAll(
            mfrFurnaceItems,
            "rubber.raw",
            "meat.nugget.raw",
            "plastic.sheet",
            "meat.ingot.raw",
            "rubberwood.log",
            "pinkslime.block");
        mfrFurnaceItems.forEach(
            itemName -> this.furnaceManager
                .addWhitelistedInput(ItemHelper.fromFriendlyName(String.format("MineFactoryReloaded:%s", itemName))));
        this.furnaceManager.addWhitelistedInputs(ItemHelper.getItemsMetaRange("MineFactoryReloaded", "stone", 0, 3));

        // FURNACE OREDICT RECIPES
        this.furnaceManager.addRecipe(new FurnaceRecipe("logWood", new ItemWrapper(Items.coal, 1), 1.0F));
        this.furnaceManager.addRecipe(new FurnaceRecipe("woodRubber", new ItemWrapper(Items.coal, 1), 1.0F));

        // CRAFT THERMAL EXPANSION BLACKLIST
        this.craftManager.addBlacklistedResults(ItemHelper.getItemsMetaRange("ThermalExpansion", "material", 1, 3));

        // CRAFT CUSTOM RECIPES
        this.craftManager
            .addRecipe(STItems.glassFrame.wrapped(), "RGR", "G G", "RGR", 'R', "itemRubber", 'G', "blockGlassHardened");
        this.craftManager
            .addRecipe(STItems.goldCoil.wrapped(), "III", "ISI", "III", 'I', "ingotGold", 'S', "stickWood");
        this.craftManager
            .addRecipe(STItems.silverCoil.wrapped(), "III", "ISI", "III", 'I', "ingotSilver", 'S', "stickWood");
        this.craftManager
            .addRecipe(STItems.electrumCoil.wrapped(), "III", "ISI", "III", 'I', "ingotElectrum", 'S', "stickWood");
        this.craftManager.addRecipe(
            ItemHelper.fromFriendlyName("ThermalExpansion:material:1"),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.goldCoil);
        this.craftManager.addRecipe(
            ItemHelper.fromFriendlyName("ThermalExpansion:material:2"),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.silverCoil);
        this.craftManager.addRecipe(
            ItemHelper.fromFriendlyName("ThermalExpansion:material:3"),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.electrumCoil);
    }

    public void registerRecipes() {
        furnaceManager.registerRecipes();
        craftManager.registerRecipes();
    }
}
