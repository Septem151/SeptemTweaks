package septem150.septemtweaks.library;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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

    public static void registerRecipes() {
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

}
