package de.unitude.notrick.cards.card.type;

public enum GermanType implements Type {

	ASS("Sau", 0), ZEHNER("10er", 1), KOENIG("König", 2), OBER("Ober", 3), UNTER(
			"Unter", 4), NEUNER("Neuner", 5), ACHTER("Achter", 6), SIEBNER(
			"Siebner", 7);

	private String name;
	private int priority;

	private GermanType(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	@Override
	public int getPriority() {
		return priority;
	}

}
