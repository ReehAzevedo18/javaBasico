package br.com.afrodev.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_personalidade")
public class Personalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="idt_personalidade")
	private Long idt;
	
	@Column(name="nme_personalidade", length = 200 )
	private String nome;
	
	public Personalidade(Long idt, String nome) {
		super();
		this.idt = idt;
		this.nome = nome;
	}
	public Personalidade(String string) {
		super();
		this.nome = nome;
	}
	public Long getIdt() {
		return idt;
	}
	public void setIdt(Long idt) {
		this.idt = idt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	

	
}