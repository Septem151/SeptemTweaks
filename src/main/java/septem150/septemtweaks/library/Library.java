package septem150.septemtweaks.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;

import septem150.septemtweaks.SeptemCreativeTab;
import septem150.septemtweaks.library.block.BlockAdamantiteOre;
import septem150.septemtweaks.library.definition.RegistryEntry;
import septem150.septemtweaks.library.item.ItemAdamantiteIngot;
import septem150.septemtweaks.library.item.ItemAdamantitePickaxe;
import septem150.septemtweaks.library.item.ItemAdamantiteSword;
import septem150.septemtweaks.library.worldgen.WorldGenAdamantite;

public class Library {

    public static CreativeTabs creativeTab = SeptemCreativeTab.getInstance();
    private static final Library.Items items = Library.Items.getInstance();
    private static final Library.Blocks blocks = Library.Blocks.getInstance();
    private static final Library.WorldGen worldGen = Library.WorldGen.getInstance();

    public static class Items {

        public static final ItemAdamantiteIngot adamantiteIngot = new ItemAdamantiteIngot(creativeTab);
        public static final ItemAdamantiteSword adamantiteSword = new ItemAdamantiteSword(creativeTab);
        public static final ItemAdamantitePickaxe adamantitePickaxe = new ItemAdamantitePickaxe(creativeTab);

        private static Library.Items instance;
        private final List<RegistryEntry> entries;

        private Items() {
            this.entries = new ArrayList<>();
            Collections.addAll(this.entries, Items.adamantiteIngot, Items.adamantiteSword, Items.adamantitePickaxe);
        }

        public static Library.Items getInstance() {
            if (instance == null) {
                instance = new Library.Items();
            }
            return instance;
        }
    }

    public static class Blocks {

        public static final BlockAdamantiteOre adamantiteOre = new BlockAdamantiteOre(creativeTab);

        private static Library.Blocks instance;
        private final List<RegistryEntry> entries;

        private Blocks() {
            this.entries = new ArrayList<>();
            Collections.addAll(this.entries, adamantiteOre);
        }

        public static Library.Blocks getInstance() {
            if (instance == null) {
                instance = new Library.Blocks();
            }
            return instance;
        }
    }

    public static class WorldGen {

        public static final WorldGenAdamantite adamantiteWorldGen = new WorldGenAdamantite();

        private static Library.WorldGen instance;
        private final List<RegistryEntry> entries;

        private WorldGen() {
            this.entries = new ArrayList<>();
            Collections.addAll(this.entries, adamantiteWorldGen);
        }

        public static Library.WorldGen getInstance() {
            if (instance == null) {
                instance = new Library.WorldGen();
            }
            return instance;
        }
    }

    public static void registerBlocks() {
        blocks.entries.forEach(entry -> entry.register());
    }

    public static void registerItems() {
        items.entries.forEach(entry -> entry.register());
    }

    public static void registerWorldGen() {
        worldGen.entries.forEach(entry -> entry.register());
    }

    public static void registerAll() {
        registerItems();
        registerBlocks();
        registerWorldGen();
    }

}
