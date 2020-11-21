package br.com.models;

import java.util.HashMap;

import br.com.util.Traducao;

public class Gato extends Animal{
	private Boolean possuiCaixaDeAreia;
	
	public Gato(){
	
	}

	public Boolean getPossuiCaixaDeAreia() {
		return possuiCaixaDeAreia;
	}

	public void setPossuiCaixaDeAreia(Boolean possuiCaixaDeAreia) {
		this.possuiCaixaDeAreia = possuiCaixaDeAreia;
	}

	@Override
	public void dizerOla() {
		System.out.println("Olá eu sou um Gato!");
	}

	public String getTraducaoPossuiCaixaDeAreia(){
		return Traducao.traduzir(this.possuiCaixaDeAreia);
		// return hasMap.get(this.getPossuiCaixaDeAreia());
	}

    
}
