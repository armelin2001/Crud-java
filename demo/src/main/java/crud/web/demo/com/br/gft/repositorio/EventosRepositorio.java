package crud.web.demo.com.br.gft.repositorio;



import org.springframework.data.repository.CrudRepository;

import crud.web.demo.com.br.gft.models.Evento;

public interface EventosRepositorio extends CrudRepository<Evento, String>{
	Evento findById(Long id);
}
