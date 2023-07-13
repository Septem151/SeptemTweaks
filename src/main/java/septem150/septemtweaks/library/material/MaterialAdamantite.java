package septem150.septemtweaks.library.material;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialAdamantite {

    public static final Material material = Material.rock;
    public static final ToolMaterial toolMaterial = EnumHelper.addToolMaterial("ADAMANTITE", 2, 832, 7.0F, 2.5F, 14);

    // WOOD ( 0, 59, 2.0F, 0.0F, 15),
    // STONE ( 1, 131, 4.0F, 1.0F, 5 ),
    // IRON ( 2, 250, 6.0F, 2.0F, 14),
    // EMERALD ( 3, 1561, 8.0F, 3.0F, 10),
    // GOLD ( 0, 32, 12.0F, 0.0F, 22);
}
