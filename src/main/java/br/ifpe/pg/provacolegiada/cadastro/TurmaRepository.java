package br.ifpe.pg.provacolegiada.cadastro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	@Query("select e from Turma e where e.curso = :curso order by e.ano, e.entrada")
	public List<Turma> findByCurso(Curso curso);
	
	@Query("select e from Turma e where e.curso = :curso AND e.entrada = :entrada AND e.turno = :turno AND e.ano = :ano order by e.ano, e.entrada")
	public List<Turma> findByTurma(Curso curso, Turno turno, int entrada, int ano);
}
