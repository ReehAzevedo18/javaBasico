import java.util.ArrayList;

import models.Animal;
import models.Cachorro;
import models.Galinha;
import models.Gato;

public class ExerciciosDeHeranca {
    
    public static void main(String[] args){
        Gato g = new Gato();
        Cachorro c  = new Cachorro();
        Galinha gal = new Galinha();
        Animal a = new Galinha(); //eu consigo por a classe galinha dentro de animal afinal galinha possui o extends a animal, porém eu não consigo ao contrário

        g.dizerOla();
        c.dizerOla();
        gal.dizerOla();
        a.dizerOla();

        //O arraylist substitui o array, onde eu percorro as classes sem precisar definir o tamanho
        ArrayList<Animal> arrayListAnimais = new ArrayList<>();
        arrayListAnimais.add(new Cachorro());
        arrayListAnimais.add(new Galinha());
        arrayListAnimais.add(new Gato());
        //Esse tipo de forEach é particulamente do Java, a partir de uma versão mais atual, porém em alguns locais quando for um java mais velho é necessario usar esse: foreach(String i: Animal)
        // arrayListAnimais.forEach(data -> {
        //     //o instanceof compara os objetos, toda a classe em Java, é um objeto
        //     if(data instanceof Gato){
        //         System.out.println("é um gato");
        //     }
        //     data.dizerOla();
        // });

        for(int i=0; i < arrayListAnimais.size(); i++){
            //Pegando 
            if(arrayListAnimais.get(i) instanceof Gato){
                //remover dados do array
                arrayListAnimais.remove(arrayListAnimais.get(i));
                i--;
            }
            //Pegando o getNome de todos os animais
            System.out.println(arrayListAnimais.get(i).getNome());
        }



        
    }
}
