package crud.web.demo.com.br.gft.erros;

public class ErrosCustomizados {
	private String mensagemErro;
	
	public ErrosCustomizados(String erro) {
		this.mensagemErro = erro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
}
