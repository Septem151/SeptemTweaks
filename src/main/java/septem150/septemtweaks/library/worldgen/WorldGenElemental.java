package septem150.septemtweaks.library.worldgen;

import septem150.septemtweaks.library.catalog.STBlocks;
import septem150.septemtweaks.library.definition.EntryWorldGen;
import septem150.septemtweaks.library.definition.WorldGenParams;

public class WorldGenElemental extends EntryWorldGen {

    // private static final WorldGenParams endGen = new
    // WorldGenParams(Blocks.end_stone, 2, 8, 10, 2, 32);
    private static final WorldGenParams overworldGen = new WorldGenParams(
        net.minecraft.init.Blocks.stone,
        1,
        2,
        12,
        42,
        100);
    // private static final WorldGenParams netherGen = new
    // WorldGenParams(Blocks.netherrack, 2, 8, 10, 2, 32);

    public WorldGenElemental() {
        super("worldgen_elemental", STBlocks.elementalOre, 100);
        // this.setDimensionGen(1, endGen);
        this.setDimensionGen(0, overworldGen);
        // this.setDimensionGen(-1, netherGen);
    }

}
