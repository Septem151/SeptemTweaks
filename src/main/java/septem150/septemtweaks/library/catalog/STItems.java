package septem150.septemtweaks.library.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import septem150.septemtweaks.library.definition.RegistryEntry;
import septem150.septemtweaks.library.item.ItemAdamantiteIngot;
import septem150.septemtweaks.library.item.ItemAdamantitePickaxe;
import septem150.septemtweaks.library.item.ItemAdamantiteSword;
import septem150.septemtweaks.library.item.ItemBluriteIngot;
import septem150.septemtweaks.library.item.ItemBluritePickaxe;
import septem150.septemtweaks.library.item.ItemElectrumCoil;
import septem150.septemtweaks.library.item.ItemElementalIngot;
import septem150.septemtweaks.library.item.ItemElementalPickaxe;
import septem150.septemtweaks.library.item.ItemGoldCoil;
import septem150.septemtweaks.library.item.ItemLovakiteIngot;
import septem150.septemtweaks.library.item.ItemLovakitePickaxe;
import septem150.septemtweaks.library.item.ItemRuniteIngot;
import septem150.septemtweaks.library.item.ItemRunitePickaxe;
import septem150.septemtweaks.library.item.ItemSilverCoil;

public class STItems {

    public static final ItemAdamantiteIngot adamantiteIngot = new ItemAdamantiteIngot();
    public static final ItemAdamantiteSword adamantiteSword = new ItemAdamantiteSword();
    public static final ItemAdamantitePickaxe adamantitePickaxe = new ItemAdamantitePickaxe();
    public static final ItemBluriteIngot bluriteIngot = new ItemBluriteIngot();
    public static final ItemBluritePickaxe bluritePickaxe = new ItemBluritePickaxe();
    public static final ItemElementalIngot elementalIngot = new ItemElementalIngot();
    public static final ItemElementalPickaxe elementalPickaxe = new ItemElementalPickaxe();
    public static final ItemLovakiteIngot lovakiteIngot = new ItemLovakiteIngot();
    public static final ItemLovakitePickaxe lovakitePickaxe = new ItemLovakitePickaxe();
    public static final ItemRuniteIngot runiteIngot = new ItemRuniteIngot();
    public static final ItemRunitePickaxe runitePickaxe = new ItemRunitePickaxe();
    public static final ItemElectrumCoil electrumCoil = new ItemElectrumCoil();
    public static final ItemGoldCoil goldCoil = new ItemGoldCoil();
    public static final ItemSilverCoil silverCoil = new ItemSilverCoil();

    private STItems() {}

    public static void preInit() {
        registerItems();
    }

    private static void registerItems() {
        List<RegistryEntry> entries = new ArrayList<>();
        Collections.addAll(
            entries,
            // adamantiteIngot,
            // adamantiteSword,
            // adamantitePickaxe,
            // bluriteIngot,
            // bluritePickaxe,
            // elementalIngot,
            // elementalPickaxe,
            // lovakiteIngot,
            // lovakitePickaxe,
            // runiteIngot,
            // runitePickaxe
            electrumCoil,
            goldCoil,
            silverCoil);
        entries.sort(Comparator.comparing(RegistryEntry::getName));
        entries.forEach(entry -> entry.register());
    }
}
