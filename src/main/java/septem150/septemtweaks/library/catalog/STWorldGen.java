package septem150.septemtweaks.library.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import septem150.septemtweaks.library.definition.RegistryEntry;
import septem150.septemtweaks.library.worldgen.WorldGenAdamantite;
import septem150.septemtweaks.library.worldgen.WorldGenBlurite;
import septem150.septemtweaks.library.worldgen.WorldGenElemental;
import septem150.septemtweaks.library.worldgen.WorldGenLovakite;
import septem150.septemtweaks.library.worldgen.WorldGenRunite;

public class STWorldGen {

    public static final WorldGenAdamantite adamantiteWorldGen = new WorldGenAdamantite();
    public static final WorldGenBlurite bluriteWorldGen = new WorldGenBlurite();
    public static final WorldGenElemental elementalWorldGen = new WorldGenElemental();
    public static final WorldGenLovakite lovakiteWorldGen = new WorldGenLovakite();
    public static final WorldGenRunite runiteWorldGen = new WorldGenRunite();

    private STWorldGen() {}

    public static void preInit() {
        // registerWorldGen();
    }

    private static void registerWorldGen() {
        List<RegistryEntry> entries = new ArrayList<>();
        Collections.addAll(
            entries,
            STWorldGen.adamantiteWorldGen,
            STWorldGen.bluriteWorldGen,
            STWorldGen.elementalWorldGen,
            STWorldGen.lovakiteWorldGen,
            STWorldGen.runiteWorldGen);
        entries.sort(Comparator.comparing(RegistryEntry::getName));
        entries.forEach(entry -> entry.register());
    }
}
