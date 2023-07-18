package septem150.septemtweaks.library.worldgen;

import septem150.septemtweaks.api.world.EntryWorldGen;
import septem150.septemtweaks.api.world.WorldGenParams;
import septem150.septemtweaks.library.catalog.STBlocks;

public class WorldGenAdamantite extends EntryWorldGen {

    // private static final WorldGenParams endGen = new
    // WorldGenParams(Blocks.end_stone, 2,
    // 8, 10, 2, 32);
    private static final WorldGenParams overworldGen = new WorldGenParams(
        net.minecraft.init.Blocks.stone,
        2,
        6,
        10,
        2,
        32);
    // private static final WorldGenParams netherGen = new WorldGenParams(
    // Blocks.netherrack, 2, 8, 10, 2, 32);

    public WorldGenAdamantite() {
        super("worldgen_adamantite", STBlocks.adamantiteOre, 50);
        // this.setDimensionGen(1, endGen);
        this.setDimensionGen(0, overworldGen);
        // this.setDimensionGen(-1, netherGen);
    }

}
