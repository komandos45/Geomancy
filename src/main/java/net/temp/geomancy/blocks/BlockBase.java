package net.temp.geomancy.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.temp.geomancy.GeomancyMod;

public class BlockBase extends Block {

	protected String name;

	public BlockBase(Material material, String name) {
		super(material);
	
		this.name = name;
		setCreativeTab(GeomancyMod.blockCreativeTab);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3f);
		setResistance(5f);
	}
	
	public void registerItemModel(Item itemBlock) {
		GeomancyMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}