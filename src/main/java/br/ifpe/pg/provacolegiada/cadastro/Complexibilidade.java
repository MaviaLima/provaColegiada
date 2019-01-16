package br.ifpe.pg.provacolegiada.cadastro;

public enum Complexibilidade {
	
	FACIL("FÁCIL"), MEDIO("MÉDIO"), DIFICIL("DIFÍCIL");

	String text;

	Complexibilidade(String t) {
		this.text = t;
	}

	public String getText() {
		if(this.text == null) {
			return "";
		}
		return this.text;
	}


}
