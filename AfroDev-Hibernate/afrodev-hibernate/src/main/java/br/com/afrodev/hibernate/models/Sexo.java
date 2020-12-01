package br.com.afrodev.hibernate.models;

public enum Sexo {
	MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

	private String nome;
	private String sigla;

	Sexo(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}





}
