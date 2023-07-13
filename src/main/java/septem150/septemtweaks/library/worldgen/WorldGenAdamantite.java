package septem150.septemtweaks.library.worldgen;

import net.minecraft.init.Blocks;

import septem150.septemtweaks.library.Library;
import septem150.septemtweaks.library.definition.EntryWorldGen;
import septem150.septemtweaks.library.definition.WorldGenParams;

public class WorldGenAdamantite extends EntryWorldGen {

    private static final WorldGenParams endGen = new WorldGenParams(Blocks.end_stone, 2, 8, 10, 2, 32);
    private static final WorldGenParams overworldGen = new WorldGenParams(Blocks.stone, 2, 8, 10, 2, 32);
    private static final WorldGenParams netherGen = new WorldGenParams(Blocks.netherrack, 2, 8, 10, 2, 32);

    public WorldGenAdamantite() {
        super("worldgen_adamantite", Library.Blocks.adamantiteOre, 0);
        this.setDimensionGen(1, endGen);
        this.setDimensionGen(0, overworldGen);
        this.setDimensionGen(-1, netherGen);
    }

}
