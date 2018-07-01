package net.temp.geomancy.mana;

public class GeoMana implements IGeoMana {

		private float geomana = 250.0F;
	@Override
	public void consume(float points) {
		this.geomana -= points;
		
		if (this.geomana < 0.0F) this.geomana = 0.0F;
	//Consume
	}

	@Override
	public void fill(float points) {
		this.geomana = points;
	//Fill	
	}

	@Override
	public void set(float points) {
		
		this.geomana = points;
		
	//set 	
	}

	@Override
	public float getGeoMana() {
		
		return this.geomana;
	}

	
}
