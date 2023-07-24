package septem150.septemtweaks.material;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolMaterial;

public class MaterialManager {

    public static void registerMaterials() {
        Map<String, Integer> blockHarvestLevels = new HashMap<>();
        blockHarvestLevels.put("stone", 2);
        blockHarvestLevels.put("cobblestone", 2);
        blockHarvestLevels.put("sandstone", 2);
        blockHarvestLevels.put("stoneAndesite", 2);
        blockHarvestLevels.put("concrete", 2);
        blockHarvestLevels.put("stoneDiorite", 2);
        blockHarvestLevels.put("stoneGranite", 2);
        blockHarvestLevels.put("limestone", 2);
        blockHarvestLevels.put("marble", 2);
        blockHarvestLevels.put("compressedCobblestone1x", 2);
        blockHarvestLevels.put("compressedCobblestone2x", 2);
        blockHarvestLevels.put("compressedCobblestone3x", 2);
        blockHarvestLevels.put("compressedCobblestone4x", 2);
        blockHarvestLevels.put("compressedCobblestone5x", 2);
        blockHarvestLevels.put("compressedCobblestone6x", 2);
        blockHarvestLevels.put("compressedCobblestone7x", 2);
        blockHarvestLevels.put("compressedCobblestone8x", 2);
        blockHarvestLevels.put("stoneMossy", 2);
        blockHarvestLevels.put("whiteStone", 2);
        blockHarvestLevels.put("oreCoal", 3);
        blockHarvestLevels.put("blockCoal", 3);
        blockHarvestLevels.put("blockCharcoalSugar", 3);
        blockHarvestLevels.put("oreNetherCoal", 3);
        blockHarvestLevels.put("oreAluminum", 3);
        blockHarvestLevels.put("blockAluminum", 3);
        blockHarvestLevels.put("blockAluminumBrass", 3);
        blockHarvestLevels.put("oreCopper", 3);
        blockHarvestLevels.put("blockCopper", 3);
        blockHarvestLevels.put("oreNetherCopper", 3);
        blockHarvestLevels.put("oreTin", 3);
        blockHarvestLevels.put("blockTin", 3);
        blockHarvestLevels.put("oreNetherTin", 3);
        blockHarvestLevels.put("oreNetherSulfur", 3);
        // SALT: <harvestcraft:salt> and <harvestcraft:spamcompressedsaltBlockalt>
        blockHarvestLevels.put("oreRuby", 3);
        blockHarvestLevels.put("blockRuby", 3);
        // RUBY: <NetherOres:tile.netherores.ore.0:13>
        blockHarvestLevels.put("orePeridot", 3);
        blockHarvestLevels.put("blockPeridot", 3);
        // PERIDOT: <NetherOres:tile.netherores.ore.0:14>
        blockHarvestLevels.put("oreTopaz", 3);
        blockHarvestLevels.put("blockTopaz", 3);
        blockHarvestLevels.put("oreTanzanite", 3);
        blockHarvestLevels.put("blockTanzanite", 3);
        blockHarvestLevels.put("oreMalachite", 3);
        blockHarvestLevels.put("blockMalachite", 3);
        blockHarvestLevels.put("oreSapphire", 3);
        blockHarvestLevels.put("blockSapphire", 3);
        // SAPPHIRE: <NetherOres:tile.netherores.ore.0:15>
        blockHarvestLevels.put("oreAmber", 3);
        blockHarvestLevels.put("blockAmber", 3);
        // AMBER: <NetherOres:tile.netherores.ore.1:11>
        // AMETHYST: <BiomesOPlenty:gemOre> <BiomesOPlenty:GemOre:1>
        blockHarvestLevels.put("blockBronze", 3);
        blockHarvestLevels.put("oreLead", 4);
        blockHarvestLevels.put("blockLead", 4);
        blockHarvestLevels.put("oreNetherLead", 4);
        blockHarvestLevels.put("oreGold", 4);
        blockHarvestLevels.put("blockGold", 4);
        blockHarvestLevels.put("oreNetherGold", 4);
        blockHarvestLevels.put("oreSilver", 4);
        blockHarvestLevels.put("blockSilver", 4);
        blockHarvestLevels.put("oreNetherSilver", 4);
        blockHarvestLevels.put("oreIron", 4);
        blockHarvestLevels.put("blockIron", 4);
        blockHarvestLevels.put("oreNetherIron", 4);
        blockHarvestLevels.put("oreNickel", 4);
        blockHarvestLevels.put("blockNickel", 4);
        blockHarvestLevels.put("oreNetherNickel", 4);
        blockHarvestLevels.put("oreLapis", 4);
        blockHarvestLevels.put("blockLapis", 4);
        blockHarvestLevels.put("oreNetherLapis", 4);
        blockHarvestLevels.put("oreRedstone", 4);
        blockHarvestLevels.put("blockRedstone", 4);
        blockHarvestLevels.put("oreNetherRedstone", 4);
        blockHarvestLevels.put("blockInvar", 4);
        blockHarvestLevels.put("blockElectrum", 4);
        blockHarvestLevels.put("blockSteel", 4);
        blockHarvestLevels.put("oreDiamond", 5);
        blockHarvestLevels.put("blockDiamond", 5);
        blockHarvestLevels.put("oreNetherDiamond", 5);
        blockHarvestLevels.put("blockEnderObsidian", 5);
        blockHarvestLevels.put("obsidian", 5);
        blockHarvestLevels.put("blockSignalum", 5);
        blockHarvestLevels.put("oreEmerald", 5);
        blockHarvestLevels.put("blockEmerald", 5);
        blockHarvestLevels.put("oreNetherEmerald", 5);
        blockHarvestLevels.put("blockAlumite", 5);
        blockHarvestLevels.put("oreCobalt", 6);
        blockHarvestLevels.put("blockCobalt", 6);
        blockHarvestLevels.put("oreArdite", 6);
        blockHarvestLevels.put("blockArdite", 6);
        blockHarvestLevels.put("oreQuartz", 6);
        blockHarvestLevels.put("blockQuartz", 6);
        blockHarvestLevels.put("burntQuartz", 6);
        blockHarvestLevels.put("blockManyullyn", 6);
        blockHarvestLevels.put("orePlatinum", 7);
        blockHarvestLevels.put("blockPlatinum", 7);
        blockHarvestLevels.put("oreNetherPlatinum", 7);
        blockHarvestLevels.put("blockEnderium", 7);
        blockHarvestLevels.put("oreMithril", 7);
        blockHarvestLevels.put("blockMithril", 7);
        blockHarvestLevels.put("oreNetherMithril", 7);
        blockHarvestLevels.put("oreCertusQuartz", 8);
        blockHarvestLevels.put("oreChargedCertusQuartz", 8);

        SeptemTweaks.LOG.info("[SeptemTweaks]: Iterating over oreDicts to change block Harvest Levels");
        for (Map.Entry<String, Integer> entry : blockHarvestLevels.entrySet()) {
            String oreDict = entry.getKey();
            int harvestLevel = entry.getValue();
            if (!OreDictionary.doesOreNameExist(oreDict)) {
                SeptemTweaks.LOG
                    .info(String.format("[SeptemTweaks]: Skipping oreDict %s as it does not exist", oreDict));
                continue;
            }
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Iterating on oreDict: %s giving Harvest Level: %d",
                    oreDict,
                    harvestLevel));
            for (ItemStack item : ItemHelper.getOreDictItems(oreDict)) {
                SeptemTweaks.LOG.info(
                    String.format(
                        "[SeptemTweaks]: Iterating on item: %s (friendly name: %s)",
                        item.toString(),
                        ItemHelper.getItemFriendlyName(new ItemWrapper(item))));
                Block block = Block.getBlockFromItem(item.getItem());
                int meta = item.getItemDamage();
                SeptemTweaks.LOG.info(
                    String.format(
                        "[SeptemTweaks]: Block from item: %s meta: %d (friendly name: %s)",
                        block.toString(),
                        meta,
                        ItemHelper.getItemFriendlyName(new ItemWrapper(block))));
                if (meta == OreDictionary.WILDCARD_VALUE) {
                    SeptemTweaks.LOG.info("[SeptemTweaks]: Meta on block was WILDCARD. Setting meta to 0.");
                    meta = 0;
                    SeptemTweaks.LOG.info(
                        String.format("[SeptemTweaks]: Block harvest level before: %d", block.getHarvestLevel(meta)));
                    block.setHarvestLevel("pickaxe", harvestLevel);
                } else {
                    SeptemTweaks.LOG.info(String.format("[SeptemTweaks]: Meta on block was %d", meta));
                    SeptemTweaks.LOG.info(
                        String.format("[SeptemTweaks]: Block harvest level before: %d", block.getHarvestLevel(meta)));
                    block.setHarvestLevel("pickaxe", harvestLevel, meta);
                }
                SeptemTweaks.LOG
                    .info(String.format("[SeptemTweaks]: Block harvest levels after: %d", block.getHarvestLevel(meta)));
            }
        }

        blockHarvestLevels.clear();
        if (Loader.isModLoaded("harvestcraft")) {
            blockHarvestLevels.put("harvestcraft:salt", 3); // Salt
            blockHarvestLevels.put("harvestcraft:spamcompressedsaltBlockalt", 3); // Salt
        }
        if (Loader.isModLoaded("NetherOres")) {
            blockHarvestLevels.put("NetherOres:tile.netherores.ore.1:13", 3); // Salt
            blockHarvestLevels.put("NetherOres:tile.netherores.ore.0:13", 3); // Ruby
            blockHarvestLevels.put("NetherOres:tile.netherores.ore.0:14", 3); // Peridot
            blockHarvestLevels.put("NetherOres:tile.netherores.ore.0:15", 3); // Sapphire
            blockHarvestLevels.put("NetherOres:tile.netherores.ore.1:11", 3); // Amber
        }
        if (Loader.isModLoaded("BiomesOPlenty")) {
            blockHarvestLevels.put("BiomesOPlenty:gemOre", 3); // Amethyst
            blockHarvestLevels.put("BiomesOPlenty:gemOre:1", 3); // Amethyst
        }

        SeptemTweaks.LOG.info("[SeptemTweaks]: Iterating over non-oredict blocks to change Harvest Levels");
        for (Map.Entry<String, Integer> entry : blockHarvestLevels.entrySet()) {
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Iterating on block: %s giving Harvest Level: %d",
                    entry.getKey(),
                    entry.getValue()));
            ItemStack item = ItemHelper.fromFriendlyName(entry.getKey()).itemStack;
            int harvestLevel = entry.getValue();
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Iterating on item: %s (friendly name: %s)",
                    item.toString(),
                    ItemHelper.getItemFriendlyName(new ItemWrapper(item))));
            Block block = Block.getBlockFromItem(item.getItem());
            int meta = item.getItemDamage();
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Block from item: %s meta: %d (friendly name: %s)",
                    block.toString(),
                    meta,
                    ItemHelper.getItemFriendlyName(new ItemWrapper(block))));
            SeptemTweaks.LOG
                .info(String.format("[SeptemTweaks]: Block harvest level before: %d", block.getHarvestLevel(meta)));
            if (meta == OreDictionary.WILDCARD_VALUE) {
                SeptemTweaks.LOG.info("[SeptemTweaks]: Meta on block was WILDCARD");
                block.setHarvestLevel("pickaxe", harvestLevel);
            } else {
                SeptemTweaks.LOG.info(String.format("[SeptemTweaks]: Meta on block was %d", meta));
                block.setHarvestLevel("pickaxe", harvestLevel, meta);
            }
            SeptemTweaks.LOG
                .info(String.format("[SeptemTweaks]: Block harvest level after: %d", block.getHarvestLevel(meta)));
        }
        registerTinkersChanges();
    }

    public static void registerTinkersChanges() {
        Map<String, Integer> toolHarvestLevels = new HashMap<>();
        toolHarvestLevels.put("Wood", 2);
        toolHarvestLevels.put("Stone", 3);
        toolHarvestLevels.put("Copper", 3);
        toolHarvestLevels.put("Bronze", 4);
        toolHarvestLevels.put("Lead", 4);
        toolHarvestLevels.put("Silver", 4);
        toolHarvestLevels.put("Iron", 4);
        toolHarvestLevels.put("Nickel", 4);
        toolHarvestLevels.put("Invar", 4);
        toolHarvestLevels.put("Electrum", 4);
        toolHarvestLevels.put("PigIron", 4);
        toolHarvestLevels.put("Steel", 5);
        toolHarvestLevels.put("Obsidian", 5);
        toolHarvestLevels.put("Alumite", 6);
        toolHarvestLevels.put("Cobalt", 6);
        toolHarvestLevels.put("Ardite", 6);
        toolHarvestLevels.put("Manyullyn", 7);
        toolHarvestLevels.put("Platinum", 8);

        Map<String, Integer> tconMapping = new HashMap<>();
        for (Map.Entry<Integer, ToolMaterial> entry : TConstructRegistry.toolMaterials.entrySet()) {
            tconMapping.put(entry.getValue().materialName, entry.getKey());
        }

        SeptemTweaks.LOG.info("[SeptemTweaks]: Iterating over tool materials to change tool Harvest Levels");
        for (Map.Entry<String, Integer> entry : toolHarvestLevels.entrySet()) {
            String toolOre = entry.getKey();
            int harvestLevel = entry.getValue();
            ToolMaterial material = TConstructRegistry.getMaterial(toolOre);
            SeptemTweaks.LOG.info(
                String.format(
                    "[SeptemTweaks]: Iterating over tool material: %s giving Harvest Level: %d",
                    toolOre,
                    harvestLevel));
            if (material == null || !tconMapping.containsKey(toolOre)) {
                SeptemTweaks.LOG.error("[SeptemTweaks]: Material before was null! Unsure what to do. Skipping entry.");
                continue;
            }
            int materialId = tconMapping.get(toolOre);
            SeptemTweaks.LOG.info(String.format("[SeptemTweaks]: Harvest Level Before: %d", material.harvestLevel()));
            // ToolStats.setHarvestLevel(toolOre, harvestLevel);
            // Remove dependency on ModTweaker, do what they do using Reflection
            ReflectionHelper.setPrivateValue(ToolMaterial.class, material, harvestLevel, "harvestLevel");
            TConstructRegistry.toolMaterials.put(materialId, material);
            TConstructRegistry.toolMaterialStrings.put(toolOre, material);
            SeptemTweaks.LOG.info(String.format("[SeptemTweaks]: Harvest Level After: %d", material.harvestLevel()));
        }
    }
}
