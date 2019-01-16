package br.ifpe.pg.provacolegiada.cadastro;

public enum Alternativas {
	
	ABERTAS("ABERTAS"), MULTIPLAS("MULTIPLAS");

	String text;

	Alternativas(String t) {
		this.text = t;
	}

	public String getText() {
		if(this.text == null) {
			return "";
		}
		return this.text;
	}

}
