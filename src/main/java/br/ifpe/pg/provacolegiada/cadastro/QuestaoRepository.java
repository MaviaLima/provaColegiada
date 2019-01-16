package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer>{

	
	public boolean existsByTopico(String topico);
}
