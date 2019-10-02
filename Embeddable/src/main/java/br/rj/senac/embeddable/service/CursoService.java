package br.rj.senac.embeddable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rj.senac.embeddable.domain.Curso;
import br.rj.senac.embeddable.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	CursoRepository repository;

	public List<Curso> findAll() {
		return repository.findAll();
	}
	
	public Curso findById(Integer cursoId) {
		return repository.findById(cursoId).get();
	}
}
