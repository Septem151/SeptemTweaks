package septem150.septemtweaks.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.UniqueIdentifier;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.library.catalog.STBlocks;
import septem150.septemtweaks.library.catalog.STItems;
import septem150.septemtweaks.library.catalog.STWorldGen;

public class Librarian {

    public static void preInit() {
        STBlocks.preInit();
        STItems.preInit();
        STWorldGen.preInit();
    }

    public static void init() {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(STItems.electrumCoil),
                new Object[] { "EEE", "ESE", "EEE", 'E', "ingotElectrum", 'S', Items.stick }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(STItems.goldCoil),
                new Object[] { "GGG", "GSG", "GGG", 'G', "ingotGold", 'S', Items.stick }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(STItems.silverCoil),
                new Object[] { "SSS", "SXS", "SSS", 'S', "ingotSilver", 'X', Items.stick }));
    }

    public static void postInit() {
        // Thermal Expansion registers items late in init() rather than preInit()
        GameRegistry.addRecipe(
            new ItemStack(STItems.glassFrame),
            new Object[] { "RGR", "G G", "RGR", 'G',
                new ItemStack(GameRegistry.findBlock("ThermalExpansion", "Glass"), 1, 0), 'R',
                GameRegistry.findItem("MineFactoryReloaded", "rubber.bar") });
    }

    public static void serverStarting() {
        // Thermal Expansion YET AGAIN does shit stupidly and late
        CraftingManager.getInstance()
            .getRecipeList()
            .removeIf((recipe) -> {
                ItemStack output = recipe.getRecipeOutput();
                for (int i = 1; i <= 3; i++) {
                    ItemStack coil = new ItemStack(GameRegistry.findItem("ThermalExpansion", "material"), 1, i);
                    if (ItemStack.areItemStacksEqual(output, coil)) {
                        return true;
                    }
                }
                return false;
            });
        ItemStack receptionCoil = new ItemStack(GameRegistry.findItem("ThermalExpansion", "material"), 1, 1);
        ItemStack transmissionCoil = new ItemStack(GameRegistry.findItem("ThermalExpansion", "material"), 1, 2);
        ItemStack conductanceCoil = new ItemStack(GameRegistry.findItem("ThermalExpansion", "material"), 1, 3);
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                receptionCoil,
                new Object[] { true, "  R", " C ", "R  ", 'R', "dustRedstone", 'C', STItems.goldCoil }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                transmissionCoil,
                new Object[] { true, "  R", " C ", "R  ", 'R', "dustRedstone", 'C', STItems.silverCoil }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                conductanceCoil,
                new Object[] { true, "  R", " C ", "R  ", 'R', "dustRedstone", 'C', STItems.electrumCoil }));

        List<ItemStack> whitelistSmeltingItems = new ArrayList<ItemStack>();
        Collections.addAll(
            whitelistSmeltingItems,
            new ItemStack(Blocks.cobblestone),
            new ItemStack(Blocks.stone),
            new ItemStack(Blocks.sand),
            new ItemStack(Blocks.log),
            new ItemStack(Blocks.log2),
            new ItemStack(Blocks.cactus),
            new ItemStack(Blocks.stonebrick),
            new ItemStack(Blocks.gravel),
            new ItemStack(Blocks.brown_mushroom),
            new ItemStack(Blocks.clay),
            new ItemStack(Blocks.red_mushroom),
            new ItemStack(Items.pumpkin_seeds),
            new ItemStack(Items.clay_ball),
            new ItemStack(Items.bread),
            new ItemStack(Items.sugar),
            new ItemStack(Items.beef),
            new ItemStack(Items.chicken),
            new ItemStack(Items.porkchop),
            new ItemStack(Items.potato),
            new ItemStack(Items.fish),
            new ItemStack(Items.fish, 1, 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "stone", 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "rubber.raw", 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "meat.nugget.raw", 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "plastic.sheet", 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "meat.ingot.raw", 1),
            GameRegistry.findItemStack("MineFactoryReloaded", "rubberwood.log", 1),
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "stone")),
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "stone"), 1, 1),
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "stone"), 1, 2),
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "stone"), 1, 3),
            new ItemStack(GameRegistry.findBlock("MineFactoryReloaded", "brick"), 1, 13),
            new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil")),
            new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil"), 1, 1),
            new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil"), 1, 2),
            new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil"), 1, 3),
            new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil"), 1, 6),
            new ItemStack(GameRegistry.findBlock("TConstruct", "materials"), 1, 36),
            GameRegistry.findItemStack("MineFactoryReloaded", "pinkslime.block", 1),
            GameRegistry.findItemStack("TConstruct", "SpeedBlock", 1));
        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.smelting()
            .getSmeltingList();
        for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = smeltingList.entrySet()
            .iterator(); entries.hasNext();) {
            Map.Entry<ItemStack, ItemStack> entry = entries.next();
            ItemStack inputItem = entry.getKey();
            UniqueIdentifier blockData = GameRegistry.findUniqueIdentifierFor(inputItem.getItem());
            String modId = blockData.modId;
            String itemName = blockData.name;
            if (modId.equals("harvestcraft") || modId.equals("claybucket")) {
                continue;
            }
            boolean isWhitelisted = false;
            for (ItemStack whitelistItem : whitelistSmeltingItems) {
                if (OreDictionary.itemMatches(inputItem, whitelistItem, false)) {
                    isWhitelisted = true;
                    break;
                }
            }
            if (!isWhitelisted) {
                entries.remove();
                SeptemTweaks.LOG.info(
                    String.format("Removing Smelting Recipe for %s:%s:%d", modId, itemName, inputItem.getItemDamage()));
            }
        }

        Librarian.addOreDictSmelting("logWood", new ItemStack(Items.coal, 1, 1), 1.0F);
        Librarian.addOreDictSmelting("woodRubber", new ItemStack(Items.coal, 1, 1), 1.0F);
    }

    private static void addOreDictSmelting(String oreDict, ItemStack result, float exp) {
        List<ItemStack> inputItems = OreDictionary.getOres(oreDict);
        for (ItemStack inputItem : inputItems) {
            GameRegistry.addSmelting(inputItem, result, exp);
        }
    }

    private static void addSmelting(ItemStack input, ItemStack result, float exp) {
        GameRegistry.addSmelting(input, result, exp);
    }

    private static void addModSmelting(String inputName, ItemStack result, float exp) {
        String[] nameInfo = inputName.split(":");
        String modId = nameInfo[0];
        String itemName = nameInfo[1];
        int metadata = OreDictionary.WILDCARD_VALUE;
        if (nameInfo.length > 2) {
            metadata = Integer.valueOf(nameInfo[2]);
        }
        ItemStack input = GameRegistry.findItemStack(modId, itemName, 1);
        if (input != null) {
            input.setItemDamage(metadata);
            GameRegistry.addSmelting(input, result, exp);
        } else {
            SeptemTweaks.LOG
                .error("[SEPTEMTWEAKS]: Attempted to register smelting recipe with null input item: " + inputName);
            SeptemTweaks.LOG.error("[SEPTEMTWEAKS]: Could not find ItemStack for " + inputName);
        }
    }

    private static void addModSmelting(String inputName, ItemStack result) {
        Librarian.addModSmelting(inputName, result, 0);
    }

    private static void addModSmelting(String inputName, String resultName, int quantity, float exp) {
        String[] nameInfo = resultName.split(":");
        String modId = nameInfo[0];
        String itemName = nameInfo[1];
        int metadata = 0;
        if (nameInfo.length > 2) {
            metadata = Integer.valueOf(nameInfo[2]);
        }
        ItemStack result = GameRegistry.findItemStack(modId, itemName, quantity);
        if (result != null) {
            result.setItemDamage(metadata);
            Librarian.addModSmelting(inputName, result, exp);
        } else {
            SeptemTweaks.LOG
                .error("[SEPTEMTWEAKS]: Attempted to register smelting recipe with null output item: " + resultName);
            SeptemTweaks.LOG.error("[SEPTEMTWEAKS]: Could not find ItemStack for " + resultName);
        }
    }

    private static void addModSmelting(String inputName, String resultName, int quantity) {
        Librarian.addModSmelting(inputName, resultName, quantity, 0.0F);
    }

    private static void addModSmelting(String inputName, String resultName, float exp) {
        Librarian.addModSmelting(inputName, resultName, 1, exp);
    }

    private static void addModSmelting(String inputName, String resultName) {
        Librarian.addModSmelting(inputName, resultName, 1, 0.0F);
    }

}
