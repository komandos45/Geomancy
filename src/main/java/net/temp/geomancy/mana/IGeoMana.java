package net.temp.geomancy.mana;

public interface IGeoMana {

	public void consume(float points);
	public void fill(float points);
	public void set(float points);
	
	public float getGeoMana();
}
