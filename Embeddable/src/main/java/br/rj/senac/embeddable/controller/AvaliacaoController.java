package br.rj.senac.embeddable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.rj.senac.embeddable.domain.Avaliacao;
import br.rj.senac.embeddable.service.AlunoService;
import br.rj.senac.embeddable.service.AvaliacaoService;
import br.rj.senac.embeddable.service.CursoService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("/adiciona")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("avaliacoes/inserir-nota");
		mv.addObject("alunos", alunoService.findAll());
		mv.addObject("cursos", cursoService.findAll());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute("avaliacao") Avaliacao avaliacao) {
		avaliacao.getAlunoCurso().setAluno(alunoService.findById(avaliacao.getAlunoCurso().getAluno().getAlunoId()));
		avaliacao.getAlunoCurso().setCurso(cursoService.findById(avaliacao.getAlunoCurso().getCurso().getCursoId()));
		avaliacaoService.save(avaliacao);
		ModelAndView mv = new ModelAndView("avaliacoes/listar-notas");
		mv.addObject("avaliacoes", avaliacaoService.findAll());
		return mv;
	}

}
