package crud.web.demo.com.br.gft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventoController {
	//Esse metodo vai retornar um formulario de cadastro do evento
	@RequestMapping("/cadastroEvento")
	public String form() {
		return "evento/formEvento";
	}
 	 
}
