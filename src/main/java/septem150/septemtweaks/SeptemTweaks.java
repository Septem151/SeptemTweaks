package septem150.septemtweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import septem150.septemtweaks.block.BlockAdamantiteOre;
import septem150.septemtweaks.block.SeptemBlock;
import septem150.septemtweaks.item.ItemAdamantiteIngot;
import septem150.septemtweaks.item.SeptemItem;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.7.10]")
public class SeptemTweaks {

    public static final Logger LOG = LogManager.getLogger(Tags.MODID);

    @SidedProxy(clientSide = "septem150.septemtweaks.ClientProxy", serverSide = "septem150.septemtweaks.CommonProxy")
    public static CommonProxy proxy;

    public static SeptemBlock blockAdamantiteOre;

    public static SeptemItem itemAdamantiteIngot;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        blockAdamantiteOre = new BlockAdamantiteOre();
        blockAdamantiteOre.register();

        itemAdamantiteIngot = new ItemAdamantiteIngot();
        itemAdamantiteIngot.register();
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about.
    // Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on
    // this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
