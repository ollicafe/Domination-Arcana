package com.ollicafe.dominationarcana.arcane;

public enum SpellType {
	
	RETURN_TO_ASH(Element.ASH, true),
	PYROCLASTIC_SURGE(Element.ASH, true),
	FIREBALL(Element.FIRE, false),
	SUMMON_SUIT(Element.IRON, true)
	
	;
	
	private boolean domination;
	private Element element;
	
	SpellType(Element element, boolean domination){
		this.domination = domination;
		this.element = element;
	}
	
	public boolean isDomination() {
		return domination;
	}
	
	public Element getElement() {
		return element;
	}

}
