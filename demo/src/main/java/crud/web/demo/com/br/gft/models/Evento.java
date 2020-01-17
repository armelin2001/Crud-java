package crud.web.demo.com.br.gft.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Evento extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	private int id;
	
	private String nome;
	private String local;
	private String data;
	private String horario;
	public static List<Evento> eventos;
	static {
		repositorioDeEventos();
	}
	public Evento(int id, String nome){
		this.nome= nome;
		this.id = id;
		
	}
	public Evento() {
		
	}
	private static void repositorioDeEventos() {
		eventos= new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	

}
