package com.ollicafe.dominationarcana.arcane;

public enum Element {
	
	ASH(Arcana.MAGUS),
	FIRE(Arcana.MAGUS),
	IRON(Arcana.ALCHEMYST);
	
	private Arcana arcana;
	
	Element(Arcana arcana){
		this.arcana = arcana;
	}
	
	public Arcana getArcana() {
		return arcana;
	}

}
