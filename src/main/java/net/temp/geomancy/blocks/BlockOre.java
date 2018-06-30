package net.temp.geomancy.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

public class BlockOre extends BlockBase {
	
	Item drop;
	int base = 1;
	int additional = 0;
	
	public BlockOre(String name, Item drop, int base, int additional) {
		//this(name, drop, base, additional);
		super(Material.ROCK, name);
		setHardness(3f);
		setResistance(5f);
		this.drop = drop;
		this.base = base;
		this.additional = additional;
	}
	
	@Override
	public BlockOre setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	} 
	
	/**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return base + random.nextInt(additional);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return drop;
    }


}