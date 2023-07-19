package septem150.septemtweaks.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import septem150.septemtweaks.api.RegistryEntry;
import septem150.septemtweaks.item.tool.ItemAdamantitePickaxe;
import septem150.septemtweaks.item.tool.ItemAdamantiteSword;
import septem150.septemtweaks.item.tool.ItemBluritePickaxe;
import septem150.septemtweaks.item.tool.ItemElementalPickaxe;
import septem150.septemtweaks.item.tool.ItemLovakitePickaxe;
import septem150.septemtweaks.item.tool.ItemRunitePickaxe;

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
    public static final ItemGlassFrame glassFrame = new ItemGlassFrame();

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
            silverCoil,
            glassFrame);
        entries.sort(Comparator.comparing(RegistryEntry::getName));
        entries.forEach(entry -> entry.register());
    }
}
