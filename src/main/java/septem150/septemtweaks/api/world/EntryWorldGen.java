package septem150.septemtweaks.api.world;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.api.RegistryEntry;

public abstract class EntryWorldGen implements IWorldGenerator, RegistryEntry {

    private final String name;
    private final Block block;
    private final Map<Integer, WorldGenParams> genParams;
    private final int modGenerationWeight;

    public EntryWorldGen(String name, Block block, int modGenerationWeight) {
        this.name = name;
        this.block = block;
        this.genParams = new HashMap<Integer, WorldGenParams>();
        this.modGenerationWeight = modGenerationWeight;
    }

    public EntryWorldGen setDimensionGen(int dimensionId, WorldGenParams dimensionGenParams) {
        this.genParams.put(dimensionId, dimensionGenParams);
        return this;
    }

    @Override
    public void register() {
        GameRegistry.registerWorldGenerator(this, this.modGenerationWeight);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        int dimensionId = world.provider.dimensionId;
        if (this.genParams.containsKey(dimensionId)) {
            WorldGenParams dimensionParams = this.genParams.get(dimensionId);
            this.generateBlock(world, rand, chunkX, chunkZ, dimensionParams);
        } else {
            SeptemTweaks.LOG
                .error(String.format("Dimension %d was not loaded for %s WorldGen!", dimensionId, this.name));
        }
    }

    protected void generateBlock(World world, Random rand, int chunkX, int chunkZ, WorldGenParams params) {
        int veinSize = params.minVeinSize + rand.nextInt(params.maxVeinSize - params.minVeinSize + 1);
        int heightRange = params.maxY - params.minY + 1;
        WorldGenMinable oreGen = new WorldGenMinable(this.block, veinSize, params.generateIn);
        for (int i = 0; i < params.chance; i++) {
            int xRand = chunkX * 16 + rand.nextInt(16);
            int yRand = rand.nextInt(heightRange) + params.minY;
            int zRand = chunkZ * 16 + rand.nextInt(16);
            oreGen.generate(world, rand, xRand, yRand, zRand);
            SeptemTweaks.LOG.info(
                String.format("Generated %s at X=%d, Z=%d, Y=%d", this.block.getLocalizedName(), xRand, zRand, yRand));
        }
    }
}
