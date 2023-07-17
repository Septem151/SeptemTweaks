package septem150.septemtweaks.library.worldgen;

import septem150.septemtweaks.library.catalog.STBlocks;
import septem150.septemtweaks.library.definition.EntryWorldGen;
import septem150.septemtweaks.library.definition.WorldGenParams;

public class WorldGenRunite extends EntryWorldGen {

    // private static final WorldGenParams endGen = new
    // WorldGenParams(Blocks.end_stone, 2, 8, 10, 2, 32);
    private static final WorldGenParams overworldGen = new WorldGenParams(
        net.minecraft.init.Blocks.stone,
        1,
        6,
        4,
        2,
        24);
    // private static final WorldGenParams netherGen = new
    // WorldGenParams(Blocks.netherrack, 2, 8, 10, 2, 32);

    public WorldGenRunite() {
        super("worldgen_runite", STBlocks.runiteOre, 100);
        // this.setDimensionGen(1, endGen);
        this.setDimensionGen(0, overworldGen);
        // this.setDimensionGen(-1, netherGen);
    }

}
