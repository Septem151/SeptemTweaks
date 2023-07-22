package septem150.septemtweaks.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.RegistryEntry;

public class STBlocks {

    private static final CreativeTabs ctab = SeptemCreativeTab.getInstance();

    public static final BlockAdamantiteOre adamantiteOre = new BlockAdamantiteOre(ctab);
    public static final BlockAdamantiteBlock adamantiteBlock = new BlockAdamantiteBlock(ctab);
    public static final BlockBluriteOre bluriteOre = new BlockBluriteOre(ctab);
    public static final BlockBluriteBlock bluriteBlock = new BlockBluriteBlock(ctab);
    public static final BlockElementalOre elementalOre = new BlockElementalOre(ctab);
    public static final BlockElementalBlock elementalBlock = new BlockElementalBlock(ctab);
    public static final BlockLovakiteOre lovakiteOre = new BlockLovakiteOre(ctab);
    public static final BlockLovakiteBlock lovakiteBlock = new BlockLovakiteBlock(ctab);
    public static final BlockRuniteOre runiteOre = new BlockRuniteOre(ctab);
    public static final BlockRuniteBlock runiteBlock = new BlockRuniteBlock(ctab);

    private STBlocks() {}

    public static void preInit() {
        // We have to register Obsidian to the oredict, because for some reason it's not by default
        OreDictionary.registerOre("obsidian", Blocks.obsidian);
        // registerBlocks();
    }

    private static void registerBlocks() {
        List<RegistryEntry> entries = new ArrayList<>();
        Collections.addAll(
            entries,
            adamantiteOre,
            adamantiteBlock,
            bluriteOre,
            bluriteBlock,
            elementalOre,
            elementalBlock,
            lovakiteOre,
            lovakiteBlock,
            runiteOre,
            runiteBlock);
        entries.sort(Comparator.comparing(RegistryEntry::getName));
        entries.forEach(entry -> entry.register());
    }
}
