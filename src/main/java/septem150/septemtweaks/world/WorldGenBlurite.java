package septem150.septemtweaks.world;

import septem150.septemtweaks.api.world.EntryWorldGen;
import septem150.septemtweaks.block.STBlocks;

public class WorldGenBlurite extends EntryWorldGen {

    // private static final WorldGenParams endGen = new
    // WorldGenParams(Blocks.end_stone, 2,
    // 8, 10, 32, 64);
    private static final WorldGenParams overworldGen = new WorldGenParams(
        net.minecraft.init.Blocks.stone,
        1,
        5,
        20,
        32,
        64);
    // private static final WorldGenParams netherGen = new WorldGenParams(
    // Blocks.netherrack, 2, 8, 10, 2, 32);

    public WorldGenBlurite() {
        super("worldgen_blurite", STBlocks.bluriteOre, 0);
        // this.setDimensionGen(1, endGen);
        this.setDimensionGen(0, overworldGen);
        // this.setDimensionGen(-1, netherGen);
    }

}
