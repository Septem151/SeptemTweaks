package septem150.septemtweaks.library.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.api.RegistryEntry;
import septem150.septemtweaks.library.block.BlockAdamantiteBlock;
import septem150.septemtweaks.library.block.BlockAdamantiteOre;
import septem150.septemtweaks.library.block.BlockBluriteBlock;
import septem150.septemtweaks.library.block.BlockBluriteOre;
import septem150.septemtweaks.library.block.BlockElementalBlock;
import septem150.septemtweaks.library.block.BlockElementalOre;
import septem150.septemtweaks.library.block.BlockLovakiteBlock;
import septem150.septemtweaks.library.block.BlockLovakiteOre;
import septem150.septemtweaks.library.block.BlockRuniteBlock;
import septem150.septemtweaks.library.block.BlockRuniteOre;

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
