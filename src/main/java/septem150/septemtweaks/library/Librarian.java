package septem150.septemtweaks.library;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
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
    }
}
