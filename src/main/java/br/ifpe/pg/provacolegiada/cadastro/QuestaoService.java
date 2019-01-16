package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {
	
	@Autowired
	private QuestaoRepository repositorio;
	
	public List<Questao> listarTodas() {
		return repositorio.findAll();
	}
	
	public Questao buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public <S extends Questao> S salvar(S entity) {
		return repositorio.saveAndFlush(entity);
	}

	public void removerPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
	

}
