package septem150.septemtweaks.api.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.Tags;
import septem150.septemtweaks.api.RegistryEntry;
import septem150.septemtweaks.util.ItemWrapper;

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

    public ItemWrapper wrapped() {
        return new ItemWrapper(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void register() {
        if (this.getCreativeTab() == null) {
            SeptemTweaks.LOG
                .warn(String.format("[SeptemTweaks]: %s was registered without a creative tab!"), this.name);

        }
        GameRegistry.registerItem(this, name);
    }

}
