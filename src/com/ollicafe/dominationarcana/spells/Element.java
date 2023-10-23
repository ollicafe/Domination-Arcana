package com.ollicafe.dominationarcana.spells;

public enum Element {
	
	ASH(Arcana.MAGUS),
	FIRE(Arcana.MAGUS);
	
	private Arcana arcana;
	
	Element(Arcana arcana){
		this.arcana = arcana;
	}
	
	public Arcana getArcana() {
		return arcana;
	}

}
