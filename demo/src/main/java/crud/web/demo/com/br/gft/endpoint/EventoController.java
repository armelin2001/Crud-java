package crud.web.demo.com.br.gft.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import crud.web.demo.com.br.gft.models.Evento;
import crud.web.demo.com.br.gft.repositorio.EventosRepositorio;

@Controller
public class EventoController {
	// na application.properties, se não tiver o data base é necessario por create na linha 11
	@Autowired
	private EventosRepositorio dao;
	
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.POST)
	public String save(Evento evento) {
		dao.save(evento);
		return "redirect:/cadastrarEvento";
	}
	@RequestMapping("/eventos")
	public ModelAndView listarEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = dao.findAll();
		mv.addObject("eventos",eventos);
		return mv;
	}
	@RequestMapping("/{id}")
	public ModelAndView detalheEvento(@PathVariable("id")long id) {
		ModelAndView mv = new ModelAndView("evento/detalheEvento");
		Evento evento = dao.findById(id);
		mv.addObject("evento",evento);
		System.out.println("evento"+evento);
		return mv;
		}
	@RequestMapping("/deletar")
	public String deletarEvento(long id) {
		Evento evento = dao.findById(id);
		dao.delete(evento);
		return "redirect:/eventos";
	}
	@RequestMapping(value="/alterar",method=RequestMethod.POST)
	public String alterarEvento(long id) {
		Evento alteraEvento = dao.findById(id);
		dao.delete(alteraEvento);
		dao.save(alteraEvento);
		return "redirect:/eventos";
	}
}
