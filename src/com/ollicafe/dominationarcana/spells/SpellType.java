package com.ollicafe.dominationarcana.spells;

public enum SpellType {
	
	RETURN_TO_ASH(true),
	PYROCLASTIC_SURGE(true),
	FIREBALL(false);
	
	private boolean domination;
	
	SpellType(boolean domination){
		this.domination = domination;
	}
	
	public boolean isDomination() {
		return domination;
	}

}
