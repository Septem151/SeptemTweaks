package septem150.septemtweaks.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
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

        List<String> foodOreTypes = Arrays.asList(
            "fishraw",
            "meatraw",
            "veggie",
            "fruit",
            "seed",
            "milk",
            "egg",
            "mushroom",
            "heavycream",
            "sugar",
            "nut",
            "spice",
            "pepper",
            "herb",
            "berry",
            "grain");
        List<ItemStack> foodstuffs = new ArrayList<>();
        for (String foodOreType : foodOreTypes) {
            foodstuffs.addAll(OreDictionary.getOres("listAll" + foodOreType));
        }

        SeptemTweaks.LOG.info("SEPTEMTWEAKS");
        for (ItemStack item : foodstuffs) {
            SeptemTweaks.LOG.info(item.toString());
        }

        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.smelting()
            .getSmeltingList();
        SeptemTweaks.LOG.info("Length: " + smeltingList.size());
        for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = smeltingList.entrySet()
            .iterator(); entries.hasNext();) {
            Map.Entry<ItemStack, ItemStack> entry = entries.next();
            ItemStack inputItem = entry.getKey();
            boolean isFood = false;
            for (ItemStack foodItem : foodstuffs) {
                // Pam's Fix
                if (inputItem.getItemDamage() == 32767) {
                    inputItem.setItemDamage(0);
                }
                if (ItemStack.areItemStacksEqual(foodItem, inputItem)) {
                    isFood = true;
                    break;
                }
            }
            if (!isFood) {
                entries.remove();
                SeptemTweaks.LOG.info("Removing Smelting Recipe for: " + inputItem.getUnlocalizedName());
            }
        }

        class OreSmelt {

            protected final List<ItemStack> inputs;
            protected final ItemStack result;
            protected final float exp;

            public OreSmelt(String oreDict, ItemStack result, float exp) {
                this(OreDictionary.getOres(oreDict), result, exp);
            }

            public OreSmelt(ItemStack input, ItemStack result, float exp) {
                this(Arrays.asList(input), result, exp);
            }

            public OreSmelt(Item input, ItemStack result, float exp) {
                this(new ItemStack(input), result, exp);
            }

            public OreSmelt(List<ItemStack> inputs, ItemStack result, float exp) {
                this.inputs = inputs;
                this.result = result;
                this.exp = exp;
            }
        }

        // take out fish

        List<OreSmelt> oreDicts = new ArrayList<>();
        Collections.addAll(
            oreDicts,
            new OreSmelt("logWood", new ItemStack(Items.coal, 1, 1), 0.1F),
            new OreSmelt("woodRubber", new ItemStack(Items.coal, 1, 1), 0.1F),
            new OreSmelt("sand", new ItemStack(Blocks.glass, 1), 0.1F),
            new OreSmelt(new ItemStack(Items.fish, 1, 1), new ItemStack(Items.cooked_fished, 1, 1), 0.1F),
            new OreSmelt(Items.fish, new ItemStack(Items.cooked_fished), 0.1F),
            new OreSmelt(Items.clay_ball, new ItemStack(Items.brick, 1), 0.1F),
            new OreSmelt(
                GameRegistry.findItem("claybucket", "unfiredClaybucket"),
                GameRegistry.findItemStack("claybucket", "claybucket", 1),
                0.1F),
            new OreSmelt(
                new ItemStack(GameRegistry.findBlock("TConstruct", "CraftedSoil"), 1, 1),
                new ItemStack(GameRegistry.findItem("TConstruct", "materials"), 1, 2),
                0.1F),
            new OreSmelt(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.stone, 1), 0.1F),
            new OreSmelt(
                GameRegistry.findItem("MineFactoryReloaded", "meat.nugget.raw"),
                new ItemStack(GameRegistry.findItem("MineFactoryReloaded", "meat.nugget.cooked")),
                0.1F),
            new OreSmelt(
                new ItemStack(Blocks.gravel),
                new ItemStack(GameRegistry.findBlock("chisel", "concrete"), 1, 0),
                0.1F),
            new OreSmelt(
                GameRegistry.findItem("harvestcraft", "coffeebeanItem"),
                new ItemStack(GameRegistry.findItem("harvestcraft", "coffeeItem")),
                0.1F));
        for (OreSmelt smeltInfo : oreDicts) {
            for (ItemStack oreStack : smeltInfo.inputs) {
                GameRegistry.addSmelting(oreStack, smeltInfo.result, smeltInfo.exp);
            }
        }
    }
}
