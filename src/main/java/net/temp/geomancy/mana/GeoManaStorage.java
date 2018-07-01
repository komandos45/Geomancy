package net.temp.geomancy.mana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class GeoManaStorage implements IStorage<IGeoMana> {

	@Override
	public NBTBase writeNBT(Capability<IGeoMana> capability, IGeoMana instance, EnumFacing side) {
	
		return new NBTTagFloat (instance.getGeoMana());
	}

	@Override
	public void readNBT(Capability<IGeoMana> capability, IGeoMana instance, EnumFacing side, NBTBase nbt) {


			instance.set(((NBTPrimitive) nbt).getFloat());
		
	}
	

}
