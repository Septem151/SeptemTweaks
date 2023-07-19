package septem150.septemtweaks.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemWrapper {

    public final ItemStack itemStack;

    public ItemWrapper(ItemStack itemStack, int quantity, int meta) {
        itemStack.stackSize = quantity;
        itemStack.setItemDamage(meta);
        this.itemStack = itemStack;
    }

    public ItemWrapper(ItemStack itemStack, int meta) {
        this(itemStack, 1, meta);
    }

    public ItemWrapper(Item item, int meta) {
        this(new ItemStack(item), 1, meta);
    }

    public ItemWrapper(Block block, int meta) {
        this(new ItemStack(block), 1, meta);
    }

    public ItemWrapper(Item item, int quantity, int meta) {
        this(new ItemStack(item), quantity, meta);
    }

    public ItemWrapper(Block block, int quantity, int meta) {
        this(new ItemStack(block), quantity, meta);
    }

    public ItemWrapper(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemWrapper(Item item) {
        this(new ItemStack(item));
    }

    public ItemWrapper(Block block) {
        this(new ItemStack(block));
    }
}
