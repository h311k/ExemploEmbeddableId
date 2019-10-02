package br.rj.senac.embeddable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rj.senac.embeddable.domain.Aluno;
import br.rj.senac.embeddable.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
	public Aluno findById(Integer alunoId) {
		return repository.findById(alunoId).get();
	}
}
