package br.ifpe.pg.provacolegiada.cadastro;

public enum Modalidade {
	
	EAD("EAD"), PRESENCIAL("PRESENCIAL");

	String text;

	Modalidade(String t) {
		this.text = t;
	}

	public String getText() {
		if(this.text == null) {
			return "";
		}
		return this.text;
	}

}
