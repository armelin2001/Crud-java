package crud.web.demo.com.br.gft.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fasterxml.jackson.core.sym.Name;

import crud.web.demo.com.br.gft.models.Evento;

public interface EventosRepositorio extends CrudRepository<Evento, Name>{
	List<Evento> findByNameIgnoreCaseContaining(String nome);
}
