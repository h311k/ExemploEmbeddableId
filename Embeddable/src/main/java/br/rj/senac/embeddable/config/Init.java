package br.rj.senac.embeddable.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.rj.senac.embeddable.domain.Aluno;
import br.rj.senac.embeddable.domain.AlunoCurso;
import br.rj.senac.embeddable.domain.Avaliacao;
import br.rj.senac.embeddable.domain.Curso;
import br.rj.senac.embeddable.repository.AlunoRepository;
import br.rj.senac.embeddable.repository.AvaliacaoRepository;
import br.rj.senac.embeddable.repository.CursoRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("José da Silva");
		aluno = alunoRepository.save(aluno);
		
		Curso curso = new Curso();
		curso.setNome("Excel Avançado");
		cursoRepository.save(curso);
		
		curso = new Curso();
		curso.setNome("Word Avançado");
		curso = cursoRepository.save(curso);
		
		Avaliacao avaliacao = new Avaliacao();
		AlunoCurso alunoCurso = new AlunoCurso();
		alunoCurso.setAluno(aluno);
		alunoCurso.setCurso(curso);
		avaliacao.setAlunoCurso(alunoCurso);
		avaliacao.setConceito("bom");
		avaliacaoRepository.save(avaliacao);

	}

	
}
