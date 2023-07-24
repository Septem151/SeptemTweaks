package septem150.septemtweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import septem150.septemtweaks.block.STBlocks;
import septem150.septemtweaks.item.STItems;
import septem150.septemtweaks.material.MaterialManager;
import septem150.septemtweaks.recipe.STRecipes;
import septem150.septemtweaks.world.STWorldGen;

@Mod(
    modid = Tags.MODID,
    version = Tags.VERSION,
    name = Tags.MODNAME,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:Forge@[10.13.4.1614,);" + "required-after:ThermalExpansion@[1.7.10R4.1.5,);"
        + "required-after:TConstruct@[1.7.10-1.8.8.build988,);"
        + "after:MineFactoryReloaded@[2.8.2B1-201,);"
        + "after:BuildCraft@[7.1.23,);"
        + "after:Chisel@[2.9.5.11,);"
        + "after:extrautilities@[1.2.12,);"
        + "after:harvestcraft@[1.7.10j,);"
        + "after:BiomesOPlenty@[2.1.0.1189,);"
        + "after:NetherOres@[2.3.1-22,);"
        + "after:appliedenergistics2@[rv3-beta-6,);"
        + "after:CraftTweaker@[3.0.13,);"
        + "after:ModTweaker2@[0.9.6,);"
        + "after:harvestthenether@[1.7.10,);"
        + "after:ClayBucket@[1.2,);"
        + "after:flintmod@[1.4,);"
        + "after:UniDict@[2.9.2,);"
        + "after:OpenBlocks@[1.7.10-1.6,);")
public class SeptemTweaks {

    public static final Logger LOG = LogManager.getLogger(Tags.MODID);

    @SidedProxy(clientSide = "septem150.septemtweaks.ClientProxy", serverSide = "septem150.septemtweaks.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        STBlocks.preInit();
        STItems.preInit();
        if (Config.genOres) {
            STWorldGen.preInit();
        }
        SeptemTweaks.LOG.info("[SeptemTweaks]: PreInit Complete.");
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about.
    // Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        SeptemTweaks.LOG.info("[SeptemTweaks]: Init Complete.");
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on
    // this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        STRecipes.initRecipes();
        SeptemTweaks.LOG.info("[SeptemTweaks]: PostInit Complete.");
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        STRecipes.registerRecipes();
        MaterialManager.registerMaterials();
        SeptemTweaks.LOG.info("[SeptemTweaks]: Load Complete.");
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
        MaterialManager.registerTinkersChanges();
    }
}
