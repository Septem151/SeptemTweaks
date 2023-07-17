package septem150.septemtweaks.library.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.definition.RegistryEntry;
import septem150.septemtweaks.library.item.ItemAdamantiteIngot;
import septem150.septemtweaks.library.item.ItemAdamantitePickaxe;
import septem150.septemtweaks.library.item.ItemAdamantiteSword;
import septem150.septemtweaks.library.item.ItemBluriteIngot;
import septem150.septemtweaks.library.item.ItemBluritePickaxe;
import septem150.septemtweaks.library.item.ItemElementalIngot;
import septem150.septemtweaks.library.item.ItemElementalPickaxe;
import septem150.septemtweaks.library.item.ItemLovakiteIngot;
import septem150.septemtweaks.library.item.ItemLovakitePickaxe;
import septem150.septemtweaks.library.item.ItemRuniteIngot;
import septem150.septemtweaks.library.item.ItemRunitePickaxe;

public class STItems {

    private static final CreativeTabs ctab = SeptemCreativeTab.getInstance();

    public static final ItemAdamantiteIngot adamantiteIngot = new ItemAdamantiteIngot(ctab);
    public static final ItemAdamantiteSword adamantiteSword = new ItemAdamantiteSword(ctab);
    public static final ItemAdamantitePickaxe adamantitePickaxe = new ItemAdamantitePickaxe(ctab);
    public static final ItemBluriteIngot bluriteIngot = new ItemBluriteIngot(ctab);
    public static final ItemBluritePickaxe bluritePickaxe = new ItemBluritePickaxe(ctab);
    public static final ItemElementalIngot elementalIngot = new ItemElementalIngot(ctab);
    public static final ItemElementalPickaxe elementalPickaxe = new ItemElementalPickaxe(ctab);
    public static final ItemLovakiteIngot lovakiteIngot = new ItemLovakiteIngot(ctab);
    public static final ItemLovakitePickaxe lovakitePickaxe = new ItemLovakitePickaxe(ctab);
    public static final ItemRuniteIngot runiteIngot = new ItemRuniteIngot(ctab);
    public static final ItemRunitePickaxe runitePickaxe = new ItemRunitePickaxe(ctab);

    private STItems() {}

    public static void init() {
        registerItems();
    }

    private static void registerItems() {
        List<RegistryEntry> entries = new ArrayList<>();
        Collections.addAll(
            entries,
            adamantiteIngot,
            adamantiteSword,
            adamantitePickaxe,
            bluriteIngot,
            bluritePickaxe,
            elementalIngot,
            elementalPickaxe,
            lovakiteIngot,
            lovakitePickaxe,
            runiteIngot,
            runitePickaxe);
        entries.sort(Comparator.comparing(RegistryEntry::getName));
        entries.forEach(entry -> entry.register());
    }
}
