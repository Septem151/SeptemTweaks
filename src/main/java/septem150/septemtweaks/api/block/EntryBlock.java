package septem150.septemtweaks.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import septem150.septemtweaks.SeptemTweaks;
import septem150.septemtweaks.Tags;
import septem150.septemtweaks.api.RegistryEntry;
import septem150.septemtweaks.util.ItemWrapper;

public abstract class EntryBlock extends Block implements RegistryEntry {

    private final String name;

    public EntryBlock(String name, Material material) {
        this(name, material, null);
    }

    public EntryBlock(String name, Material material, CreativeTabs creativeTab) {
        super(material);
        this.name = name;
        this.setBlockName(String.format("%s.%s", Tags.MODID, name));
        this.setBlockTextureName(String.format("%s:%s", Tags.MODID, name));
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
        if (this.getCreativeTabToDisplayOn() == null) {
            SeptemTweaks.LOG
                .warn(String.format("[SeptemTweaks]: %s was registered without a creative tab!"), this.name);
        }
        GameRegistry.registerBlock(this, name);
    }

}
