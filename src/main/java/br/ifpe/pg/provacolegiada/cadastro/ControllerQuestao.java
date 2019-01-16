package br.ifpe.pg.provacolegiada.cadastro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/questoes/")
public class ControllerQuestao {
	
	@Autowired
	private QuestaoService questaoService;
	@Autowired
	private DisciplinaService disciplinaService;

	@RequestMapping(value="saveList", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView salvarPesquisarDisciplina(@Valid @ModelAttribute Questao questao, @RequestParam(value="action", 
		required=false) String action, Errors errors, RedirectAttributes ra) {
		
		if (action != null && action.equals("salvar")) {
			return salvar(questao, errors, ra);
		} else {
			return pesquisar(questao);
		}
	}
	
	@GetMapping("list")
	public ModelAndView pesquisar(Questao questao) {
		ModelAndView mv = new ModelAndView("cadastros/questoes-list");
		if (questao == null) {
			mv.addObject("lista", questaoService.listarTodas());	
		} 
		mv.addObject("listaDisciplina", disciplinaService.listarTodas());
		mv.addObject("listaComplexibilidade", Complexibilidade.values());
		mv.addObject("listaQuestoes", Alternativas.values());
		return mv;
	}

	private ModelAndView salvar(@Valid @ModelAttribute Questao questao, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível salvar disciplina: " + errors.getFieldErrors());
		} else {
			try {
				questaoService.salvar(questao);
				ra.addFlashAttribute("mensagemSucesso", "Questão salva com sucesso !");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível salvar questão: " + e.getMessage());
			}
		}
		return pesquisar(new Questao());
	}

	@GetMapping("edit/{id}")
	public ModelAndView exibirEdicao(@PathVariable("id") Integer id) {
		Questao questao = questaoService.buscarPorId(id);
		
		ModelAndView mv = new ModelAndView("cadastros/disciplinas-list");
		mv.addObject("lista", questaoService.listarTodas());
		mv.addObject("listaDisciplina", disciplinaService.listarTodas());
		mv.addObject("listaComplexibilidade", Complexibilidade.values());
		mv.addObject("listaQuestoes", Alternativas.values());
		mv.addObject("questao", questao);
		return mv;
	}

	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes ra) {
		questaoService.removerPorId(id);
		ra.addFlashAttribute("mensagemSucesso", "Questão removida com sucesso");
		return "redirect:/questoes/list";
	}


}
