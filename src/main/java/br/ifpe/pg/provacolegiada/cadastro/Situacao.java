package br.ifpe.pg.provacolegiada.cadastro;

public enum Situacao {
	
	ATIVO("ATIVO"), INATIVO("INATIVO");

	String text;

	Situacao(String t) {
		this.text = t;
	}

	public String getText() {
		if(this.text == null) {
			return "";
		}
		return this.text;
	}

}
