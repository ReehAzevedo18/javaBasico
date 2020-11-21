package br.com.dao;

import java.util.ArrayList;

import br.com.inter.AnimalDAOInterface;
import br.com.models.Animal;

public class AnimalDAO implements AnimalDAOInterface {
    private ArrayList<Animal> animais;
    private Long identificadorCount;

    public AnimalDAO(){
        this.animais = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimais(){
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais){
        this.animais = animais;
        this.identificadorCount = 0L;
    }

    @Override
    public Animal buscarAnimal(Integer identificador) {
        return null;
    }

    public Animal buscarAnimal(Long identificador){
        Animal retorno = null;
        for(Animal a: animais){
            if(a.getIdentificador().equals(identificador)){
                retorno = a;
            }
        }
        return retorno;
    }
 

    @Override
    public Animal buscarAnimalPorNome(String nome) {
        Animal retorno = null;
        for(Animal a: animais){
            if(a.getNome().toUpperCase().equals(nome.toUpperCase())){
                retorno = a;
            }
        }
        return null;
    }

    @Override
    public int deletarAnimal(Animal animal) {
        if(animal != null){
            this.animais.remove(animal);
            return 1;
        }
        return 0;
    }

    @Override
    public int deletarAnimal(ArrayList<Animal> animais) {
        if(animais.size() > 0){
            this.animais.removeAll(animais);
            return 1;
        }   
        return 0;
    }

    @Override
    public int cadastrarAnimal(Animal animal) {
        if(animal != null){
            animal.setIdentificador(this.identificadorCount++); //fazendo a contagem de cadastros
            this.animais.add(animal);
            return 1;
        }
        return 0;
    }

    @Override
    public int cadastrarAnimal(ArrayList<Animal> animal) {
        if(animais.size() > 0)
        for(Animal a: animais){
            a.setIdentificador(this.identificadorCount++);
        }
            this.animais.addAll(animais);
            return 1;
    }

    @Override
    public ArrayList<Animal> consultarAnimais() {
        return animais;
    }

    
}   
