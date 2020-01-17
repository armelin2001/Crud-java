package crud.web.demo.com.br.gft.endpoint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.web.demo.com.br.gft.erros.RecursosNaoEncontrados;
import crud.web.demo.com.br.gft.models.Evento;
import crud.web.demo.com.br.gft.repositorio.EventosRepositorio;

@RestController
@RequestMapping("Eventos")
public class EventoEndponit {
	private final EventosRepositorio dao;
	/*public String acharElemento(List<Evento> evento) {
		Evento
	}*/
	@Autowired
	public EventoEndponit(EventosRepositorio daoEvento) {
		this.dao = daoEvento;
	}

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}")
	public ResponseEntity<?> getNomeById(@PathVariable("id") Long id) {
		Optional<Evento> evento = dao.findById(nome);
		if (evento == null) {
			throw new RecursosNaoEncontrados("Evento não encontrado pelo nome: "+ nome);
		}
		return new ResponseEntity<>(evento, HttpStatus.ACCEPTED);
	}
	@GetMapping(path = "/acharEventos/{nome}")
	public ResponseEntity<?> acharEventosPeloNome(@PathVariable String nome) {
		return new ResponseEntity<>(dao.findByNameIgnoreCaseContaining(nome), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Evento evento) {
		return new ResponseEntity<>(dao.save(evento), HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Evento evento) {
		dao.delete(evento);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Evento evento) {
		dao.save(evento);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verificarSeEventoExiste(Long id) {
		if (dao.findFirst(id) == null) {
			throw new RecursosNaoEncontrados("Evento não encontrado pelo nome: "+ nome);
		}
	}
}
