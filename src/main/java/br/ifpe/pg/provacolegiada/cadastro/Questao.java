package br.ifpe.pg.provacolegiada.cadastro;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@NotBlank
	private String topico;
	
	@Enumerated(EnumType.STRING)
	private Alternativas tipoAlternativas;
	
	@Enumerated(EnumType.STRING)
	private Complexibilidade complexibilidade;
	
	@NotBlank
	private String descricao;
	
	@ManyToOne
	private Pergunta respPergunta;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public Alternativas getTipoAlternativas() {
		return tipoAlternativas;
	}

	public void setTipoAlternativas(Alternativas tipoAlternativas) {
		this.tipoAlternativas = tipoAlternativas;
	}

	public Complexibilidade getComplexibilidade() {
		return complexibilidade;
	}

	public void setComplexibilidade(Complexibilidade complexibilidade) {
		this.complexibilidade = complexibilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pergunta getRespPergunta() {
		return respPergunta;
	}

	public void setRespPergunta(Pergunta respPergunta) {
		this.respPergunta = respPergunta;
	}


	
	
	

}
