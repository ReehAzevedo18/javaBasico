package br.com.inter;

import java.util.ArrayList;

import br.com.models.Animal;

public interface AnimalDAOInterface {
    public Animal buscarAnimal(Integer identificador);

    public Animal buscarAnimalPorNome(String nome);

    public int deletarAnimal(Animal animal);

    public int deletarAnimal(ArrayList<Animal> animais);

    public int cadastrarAnimal(Animal animal);

    public int cadastrarAnimal(ArrayList<Animal> animal);

    public ArrayList<Animal> consultarAnimais();
}
