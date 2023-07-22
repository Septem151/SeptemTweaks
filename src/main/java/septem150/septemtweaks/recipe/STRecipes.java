package septem150.septemtweaks.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.rwtema.extrautils.ExtraUtils;

import cofh.thermalexpansion.block.TEBlocks;
import cofh.thermalexpansion.block.machine.BlockMachine;
import cofh.thermalexpansion.block.simple.BlockFrame;
import cofh.thermalexpansion.block.simple.BlockGlass;
import cofh.thermalexpansion.block.tank.BlockTank;
import cofh.thermalexpansion.item.TEItems;
import cofh.thermalexpansion.util.crafting.RecipeMachine;
import cofh.thermalexpansion.util.crafting.RecipeMachineUpgrade;
import cofh.thermalexpansion.util.crafting.SmelterManager;
import septem150.septemtweaks.item.STItems;
import septem150.septemtweaks.recipe.furnace.FurnaceManager;
import septem150.septemtweaks.recipe.furnace.FurnaceRecipe;
import septem150.septemtweaks.util.ItemHelper;
import septem150.septemtweaks.util.ItemWrapper;
import tconstruct.TConstruct;
import tconstruct.library.crafting.CastingRecipe;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;

public class STRecipes {

    private static final FurnaceManager furnaceManager = FurnaceManager.getInstance();
    private static final CraftManager craftManager = CraftManager.getInstance();

    private STRecipes() {}

    public static void initRecipes() {
        // FURNACE MODS WHITELIST
        furnaceManager.addWhitelistedMods("harvestcraft", "claybucket");

        // FURNACE VANILLA WHITELIST
        furnaceManager.addWhitelistedInputs(
            new ItemWrapper(Blocks.cobblestone),
            new ItemWrapper(Blocks.stone),
            new ItemWrapper(Blocks.sand),
            new ItemWrapper(Blocks.log),
            new ItemWrapper(Blocks.log2),
            new ItemWrapper(Blocks.cactus),
            new ItemWrapper(Blocks.stonebrick),
            new ItemWrapper(Blocks.gravel),
            new ItemWrapper(Blocks.brown_mushroom),
            new ItemWrapper(Blocks.clay),
            new ItemWrapper(Blocks.red_mushroom),
            new ItemWrapper(Items.pumpkin_seeds),
            new ItemWrapper(Items.clay_ball),
            new ItemWrapper(Items.bread),
            new ItemWrapper(Items.sugar),
            new ItemWrapper(Items.beef),
            new ItemWrapper(Items.chicken),
            new ItemWrapper(Items.porkchop),
            new ItemWrapper(Items.potato),
            new ItemWrapper(Items.fish),
            new ItemWrapper(Items.fish, 1));

        // FURNACE TCONSTRUCT WHITELIST
        List<String> tcFurnaceItems = new ArrayList<>();
        Collections.addAll(tcFurnaceItems, "CraftedSoil:6", "materials:36", "materials:37", "SpeedBlock");
        tcFurnaceItems.forEach(
            itemName -> furnaceManager
                .addWhitelistedInput(ItemHelper.fromFriendlyName(String.format("TConstruct:%s", itemName))));
        furnaceManager.addWhitelistedInputs(ItemHelper.getItemsMetaRange("TConstruct", "CraftedSoil", 0, 3));

        // FURNACE MINEFACTORY RELOADED WHITELIST
        List<String> mfrFurnaceItems = new ArrayList<>();
        Collections.addAll(
            mfrFurnaceItems,
            "rubber.raw",
            "meat.nugget.raw",
            "plastic.sheet",
            "meat.ingot.raw",
            "rubberwood.log",
            "pinkslime.block");
        mfrFurnaceItems.forEach(
            itemName -> furnaceManager
                .addWhitelistedInput(ItemHelper.fromFriendlyName(String.format("MineFactoryReloaded:%s", itemName))));
        furnaceManager.addWhitelistedInputs(ItemHelper.getItemsMetaRange("MineFactoryReloaded", "stone", 0, 3));

        // FURNACE OREDICT RECIPES
        furnaceManager.addRecipe(new FurnaceRecipe("logWood", new ItemWrapper(Items.coal, 1), 1.0F));
        furnaceManager.addRecipe(new FurnaceRecipe("woodRubber", new ItemWrapper(Items.coal, 1), 1.0F));

        // CRAFT VANILLA BLACKLIST
        List<Item> vanillaItems = new ArrayList<>();
        Collections.addAll(
            vanillaItems,
            Items.wooden_pickaxe,
            Items.stone_pickaxe,
            Items.iron_pickaxe,
            Items.golden_pickaxe,
            Items.diamond_pickaxe,
            Items.wooden_axe,
            Items.stone_axe,
            Items.iron_axe,
            Items.golden_axe,
            Items.diamond_axe,
            Items.wooden_shovel,
            Items.stone_shovel,
            Items.iron_shovel,
            Items.golden_shovel,
            Items.diamond_shovel,
            Items.wooden_hoe,
            Items.stone_hoe,
            Items.iron_hoe,
            Items.golden_hoe,
            Items.diamond_hoe,
            Items.wooden_sword,
            Items.stone_sword,
            Items.iron_sword,
            Items.golden_sword,
            Items.diamond_sword);
        vanillaItems.forEach(item -> craftManager.addBlacklistedResult(new ItemWrapper(item)));

        // CRAFT THERMAL EXPANSION BLACKLIST
        craftManager.addBlacklistedResults(ItemHelper.getItemsMetaRange("ThermalExpansion", "Frame", 0, 3));
        craftManager.addBlacklistedResults(ItemHelper.getItemsMetaRange("ThermalExpansion", "Machine", 0, 5));

        // CRAFT EXTRA UTILITIES BLACKLIST
        craftManager.addBlacklistedResults(ItemHelper.getItemsMetaRange("ExtraUtilities", "decorativeBlock2", 10, 11));

        // CRAFT CUSTOM RECIPES
        craftManager
            .addRecipe(STItems.glassFrame.wrapped(), "RGR", "G G", "RGR", 'R', "itemRubber", 'G', "blockGlassHardened");
        craftManager.addRecipe(STItems.goldCoil.wrapped(), "III", "ISI", "III", 'I', "ingotGold", 'S', "stickWood");
        craftManager.addRecipe(STItems.silverCoil.wrapped(), "III", "ISI", "III", 'I', "ingotSilver", 'S', "stickWood");
        craftManager
            .addRecipe(STItems.electrumCoil.wrapped(), "III", "ISI", "III", 'I', "ingotElectrum", 'S', "stickWood");
        craftManager.replaceRecipes(
            new ItemWrapper(Blocks.furnace),
            "CCC",
            "CFC",
            "CCC",
            'C',
            "compressedCobblestone1x",
            'F',
            Items.flint);
        craftManager.replaceRecipes(
            new ItemWrapper(TEItems.powerCoilGold),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.goldCoil);
        craftManager.replaceRecipes(
            new ItemWrapper(TEItems.powerCoilSilver),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.silverCoil);
        craftManager.replaceRecipes(
            new ItemWrapper(TEItems.powerCoilElectrum),
            "  R",
            " C ",
            "R  ",
            'R',
            "dustRedstone",
            'C',
            STItems.electrumCoil);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockTank.tankBasic),
            "IGI",
            "BFB",
            "IGI",
            'I',
            "ingotInvar",
            'G',
            "gearCopper",
            'B',
            Blocks.iron_bars,
            'F',
            STItems.glassFrame);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockTank.tankHardened),
            "IFI",
            "ITI",
            "IFI",
            'I',
            "ingotSteel",
            'F',
            STItems.glassFrame,
            'T',
            BlockTank.tankBasic);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockTank.tankReinforced),
            "IFI",
            "ITI",
            "IFI",
            'I',
            "ingotAlumite",
            'F',
            STItems.glassFrame,
            'T',
            BlockTank.tankHardened);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockTank.tankResonant),
            "IFI",
            "ITI",
            "IFI",
            'I',
            "ingotEnderium",
            'F',
            STItems.glassFrame,
            'T',
            BlockTank.tankReinforced);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockFrame.frameMachineBasic),
            "IGI",
            "GXG",
            "IGI",
            'I',
            "ingotInvar",
            'G',
            "blockGlass",
            'X',
            "gearBronze");
        craftManager.replaceRecipes(
            new ItemWrapper(BlockFrame.frameMachineHardened),
            "IXI",
            "GFG",
            "IGI",
            'I',
            "ingotSteel",
            'G',
            "blockGlassHardened",
            'X',
            "gearElectrum",
            'F',
            BlockFrame.frameMachineBasic);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockFrame.frameMachineReinforced),
            "IXI",
            "GFG",
            "IGI",
            'I',
            "ingotAlumite",
            'G',
            new ItemStack(ExtraUtils.decorative2, 1, 10),
            'X',
            "gearSignalum",
            'F',
            BlockFrame.frameMachineHardened);
        craftManager.replaceRecipes(
            new ItemWrapper(BlockFrame.frameMachineResonant),
            "IXI",
            "GFG",
            "IGI",
            'I',
            "ingotManyullyn",
            'G',
            new ItemStack(ExtraUtils.decorative2, 1, 11),
            'X',
            "gearEnderium",
            'F',
            BlockFrame.frameMachineReinforced);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.furnace,
                BlockMachine.defaultAugments,
                new Object[] { " R ", "BFB", "GCG", 'R', "dustRedstone", 'B', Blocks.brick_block, 'F',
                    "thermalexpansion:machineFrame", 'G', "gearBronze", 'C', TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.furnace);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.pulverizer,
                BlockMachine.defaultAugments,
                new Object[] { " H ", "BMB", "GCG", 'H', new ItemStack(TinkerTools.hammerHead, 1, 1020), 'B',
                    new ItemStack(TinkerSmeltery.smeltery, 1, 2), 'M', "thermalexpansion:machineFrame", 'G',
                    "gearBronze", 'C', TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.pulverizer);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.sawmill,
                BlockMachine.defaultAugments,
                new Object[] { " A ", "PMP", "GCG", 'A', new ItemStack(TinkerTools.hatchetHead, 1, 2), 'P', "plankWood",
                    'M', "thermalexpansion:machineFrame", 'G', "gearBronze", 'C', TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.sawmill);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.smelter,
                BlockMachine.defaultAugments,
                new Object[] { "GES", "IMI", "DCD", 'G', STItems.goldCoil, 'E', STItems.electrumCoil, 'S',
                    STItems.silverCoil, 'I', "ingotSteel", 'M', "thermalexpansion:machineFrame", 'D', "gearDiamond",
                    'C', TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.smelter);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.crucible,
                BlockMachine.defaultAugments,
                new Object[] { " T ", "BMB", "DCD", 'T', BlockTank.tankBasic, 'B', new ItemStack(Blocks.nether_brick),
                    'M', "thermalexpansion:machineFrame", 'D', "gearDiamond", 'C', TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.crucible);
        craftManager.addRecipe(
            new RecipeMachine(
                BlockMachine.transposer,
                BlockMachine.defaultAugments,
                new Object[] { "BTB", "GMG", "XCX", 'B', Items.bucket, 'T', BlockTank.tankBasic, 'G',
                    "blockGlassHardened", 'M', "thermalexpansion:machineFrame", 'X', "gearDiamond", 'C',
                    TEItems.powerCoilGold }));
        STRecipes.upgradeMachineRecipes(BlockMachine.transposer);
    }

    private static void upgradeMachineRecipes(ItemStack machine) {
        craftManager.addRecipe(
            new RecipeMachineUpgrade(
                1,
                RecipeMachineUpgrade.getMachineLevel(machine, 1),
                new Object[] { "IXI", "GMG", "IGI", 'I', "ingotSteel", 'G', "blockGlassHardened", 'X', "gearElectrum",
                    'M', RecipeMachineUpgrade.getMachineLevel(machine, 0) }));
        craftManager.addRecipe(
            new RecipeMachineUpgrade(
                2,
                RecipeMachineUpgrade.getMachineLevel(machine, 2),
                new Object[] { "IXI", "GMG", "IGI", 'I', "ingotAlumite", 'G',
                    new ItemStack(ExtraUtils.decorative2, 1, 10), 'X', "gearSignalum", 'M',
                    RecipeMachineUpgrade.getMachineLevel(machine, 1) }));
        craftManager.addRecipe(
            new RecipeMachineUpgrade(
                3,
                RecipeMachineUpgrade.getMachineLevel(machine, 3),
                new Object[] { "IXI", "GMG", "IGI", 'I', "ingotManyullyn", 'G',
                    new ItemStack(ExtraUtils.decorative2, 1, 11), 'X', "gearEnderium", 'M',
                    RecipeMachineUpgrade.getMachineLevel(machine, 2) }));
    }

    public static void registerRecipes() {
        furnaceManager.registerRecipes();
        craftManager.registerRecipes();
        SmelterManager.addAlloyRecipe(
            6000,
            BlockGlass.glassHardened,
            new ItemStack(Items.diamond),
            new ItemStack(ExtraUtils.decorative2, 1, 10));
        SmelterManager.addAlloyRecipe(
            8000,
            new ItemStack(ExtraUtils.decorative2, 1, 10),
            ItemHelper.getOreDictItems("dustCobalt")
                .get(0)
                .copy(),
            new ItemStack(ExtraUtils.decorative2, 1, 11));
        ItemStack obsidianDust4 = ItemHelper.getOreDictItems("dustObsidian")
            .get(0)
            .copy();
        obsidianDust4.stackSize = 4;
        ItemStack ingotLead = ItemHelper.getOreDictItems("ingotLead")
            .get(0)
            .copy();
        ItemStack dustLead = ItemHelper.getOreDictItems("dustLead")
            .get(0)
            .copy();
        ItemStack ingotLumium = ItemHelper.getOreDictItems("ingotLumium")
            .get(0)
            .copy();
        ItemStack dustLumium = ItemHelper.getOreDictItems("dustLumium")
            .get(0)
            .copy();
        SmelterManager.addAlloyRecipe(4000, ingotLead, obsidianDust4, BlockGlass.glassHardened);
        SmelterManager.addAlloyRecipe(4000, dustLead, obsidianDust4, BlockGlass.glassHardened);
        SmelterManager.addAlloyRecipe(4000, ingotLumium, obsidianDust4, BlockGlass.glassHardenedIlluminated);
        SmelterManager.addAlloyRecipe(4000, dustLumium, obsidianDust4, BlockGlass.glassHardenedIlluminated);
        for (Iterator<CastingRecipe> castRecipes = TConstruct.getBasinCasting()
            .getCastingRecipes()
            .iterator(); castRecipes.hasNext();) {
            CastingRecipe castRecipe = castRecipes.next();
            if (ItemHelper
                .areItemsEqual(new ItemWrapper(castRecipe.getResult()), new ItemWrapper(TEBlocks.blockGlass, 0))) {
                castRecipes.remove();
                break;
            }
        }
    }
}
