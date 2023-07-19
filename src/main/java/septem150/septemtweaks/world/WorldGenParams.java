package septem150.septemtweaks.world;

import net.minecraft.block.Block;

public class WorldGenParams {

    public final Block generateIn;
    public final int minVeinSize;
    public final int maxVeinSize;
    public final int chance;
    public final int minY;
    public final int maxY;

    public WorldGenParams(Block generateIn, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY) {
        this.generateIn = generateIn;
        this.minVeinSize = minVeinSize;
        this.maxVeinSize = maxVeinSize;
        this.chance = chance;
        this.minY = minY;
        this.maxY = maxY;
    }

}
