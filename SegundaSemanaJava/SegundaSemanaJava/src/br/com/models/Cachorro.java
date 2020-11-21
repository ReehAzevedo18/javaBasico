package br.com.models;

import br.com.util.Traducao;

public class Cachorro extends Animal {
    private Boolean possuiCama;

	public Boolean getPossuiCama() {
		return possuiCama;
	}

	public void setPossuiCama(Boolean possuiCama) {
		this.possuiCama = possuiCama;
	}
	@Override
	public void dizerOla() {
		System.out.println("Olá eu sou uma Cachorro!");
	}
	
	public String getTraducaoPorssuiCama(){
		return Traducao.traduzir(this.possuiCama);
	}
}
