package br.rj.senac.embeddable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rj.senac.embeddable.domain.Avaliacao;
import br.rj.senac.embeddable.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository repository;
	
	public Avaliacao save(Avaliacao avaliacao) {
		return repository.save(avaliacao);
	}
	
	public List<Avaliacao> findAll() {
		return repository.findAll();
	}
}
