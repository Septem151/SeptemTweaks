package septem150.septemtweaks.library.definition;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.Tags;

public abstract class EntryItem extends Item implements RegistryEntry {

    private final String name;

    public EntryItem(String name) {
        this(name, null);
    }

    public EntryItem(String name, CreativeTabs creativeTab) {
        super();
        this.name = name;
        this.setUnlocalizedName(String.format("%s.%s", Tags.MODID, name));
        this.setTextureName(String.format("%s:%s", Tags.MODID, name));
        this.setCreativeTab(creativeTab);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void register() {
        if (this.getCreativeTab() == null) {
            SeptemTweaks.LOG.warn(String.format("%s was registered without a creative tab!"), this.name);

        }
        GameRegistry.registerItem(this, name);
    }

}
