package septem150.septemtweaks.library.definition;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.Tags;

public abstract class EntrySword extends ItemSword implements RegistryEntry {

    private final String name;

    public EntrySword(String name, ToolMaterial material) {
        this(name, material, null);
    }

    public EntrySword(String name, ToolMaterial material, CreativeTabs creativeTab) {
        super(material);
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
