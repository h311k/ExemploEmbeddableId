package br.rj.senac.embeddable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rj.senac.embeddable.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
