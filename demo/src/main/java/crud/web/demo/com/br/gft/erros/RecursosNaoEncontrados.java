package crud.web.demo.com.br.gft.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursosNaoEncontrados extends RuntimeException{
	public RecursosNaoEncontrados(String mensagem) {
		super(mensagem);
	}
}
