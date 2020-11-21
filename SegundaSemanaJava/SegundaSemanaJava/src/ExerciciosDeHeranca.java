import java.util.ArrayList;
import java.util.Scanner;

import br.com.dao.AnimalDAO;
import br.com.models.*;

public class ExerciciosDeHeranca {
    
    public static void main(String[] args){
        //O arraylist substitui o array, onde eu percorro as classes sem precisar definir o tamanho
        // ArrayList<Animal> arrayListAnimais = new ArrayList<>();
        // menu(arrayListAnimais);
        
        AnimalDAO animais = new AnimalDAO();        
        menu(animais);
        // Animal a = new Galinha(); //eu consigo por a classe galinha dentro de animal afinal galinha possui o extends a animal, porém eu não consigo ao contrário

        // Animal ab = new Animal();
        // for(Animal a: arrayListAnimais){
        //     arrayListAnimais.remove(0);
        //     ab = a;
        // }

        // arrayListAnimais.forEach(data->{
        //     data.setIdade(10);
        //     data.dizerOla();
        // });

        // ArrayList<Animal> animaisParaDeletar = new ArrayList<Animal>();
        // for(int i=0; i < arrayListAnimais.size(); i++){
        //     //Pegando 
        //     if(arrayListAnimais.get(i) instanceof Gato){
        //         //remover dados do array
        //         animaisParaDeletar.remove(arrayListAnimais.get(i));
        //         i--;
        //     }
        //     //Pegando o getNome de todos os animais
        //     System.out.println(arrayListAnimais.get(i).getNome());
        // }
        // //Utilizando a collection para deletar todos os animais
        // arrayListAnimais.removeAll(animaisParaDeletar);

        //Adicionando dados nas classes
        // arrayListAnimais.add(new Cachorro());
        // arrayListAnimais.add(new Galinha());
        // arrayListAnimais.add(new Gato());
        //Esse tipo de forEach é particulamente do Java, a partir de uma versão mais atual, porém em alguns locais quando for um java mais velho é necessario usar esse: foreach(String i: Animal)
        // arrayListAnimais.forEach(data -> {
        //     //o instanceof compara os objetos, toda a classe em Java, é um objeto
        //     if(data instanceof Gato){
        //         System.out.println("é um gato");
        //     }
        //     data.dizerOla();
        // });
   
    }
       //Faça um programa para ler animais e ao fechar  imprimir quantos são Cachorros, gatos e galinhas
       public static void menu(AnimalDAO dao){
        Scanner sc = new Scanner(System.in);
        Integer opcao = 0;
        Integer qtdeGato = 0;
        Integer qtdeCachorro = 0;
        Integer qtdeGalinha = 0;

        do{
            opcao = Leitor.lerValor("0) Sair \n 1) Cadastrar \n 2) Listar animais \n 3) Deletar animal por identificador", sc, opcao);
            switch(opcao){
                case 0:
                    System.out.println("Saindo ...");
                    for(Animal a: dao.consultarAnimais()){
                        if(a instanceof Gato){
                            qtdeGato++;
                        }else if(a instanceof Cachorro){
                            qtdeCachorro++;
                        }else if(a instanceof Galinha){
                            qtdeGalinha++;
                        }
                    }
                    System.out.printf("Gato:", qtdeGato);
                    System.out.printf("Cachorro:", qtdeCachorro);
                    System.out.printf("Galinha:", qtdeGalinha);
                    break;
                case 1:
                    int i = dao.cadastrarAnimal(cadastrarAnimal(sc));
                    if(i > 0){
                        System.out.println("Cadastrado com sucesso!");
                    }
                    // arrayListAnimais.add(cadastrarAnimal()); Do meu método
                    break;
                case 2: 
                    ListarAnimais(dao.consultarAnimais());
                    break;
                case 3:
                   int testeDelete = deletarAnimais(dao, sc);
                   if(testeDelete > 0){
                       System.out.println("Deletado com sucesso!");
                   }
                    break;
                default:
                    break;
            }
        }while(opcao != 0);

        }

        private static void ListarAnimais(ArrayList<Animal> animais){
            for(Animal a: animais){
                if(a instanceof Gato){
                    Gato gato = (Gato) a;
                    imprimir(gato);
                }else if(a instanceof Cachorro){
                    Cachorro cachorro = (Cachorro) a;
                    imprimir(cachorro);
                }else if(a instanceof Galinha){
                    Galinha galinha = (Galinha) a;
                    imprimir(galinha);
                }
            }
        }

        private static void imprimir(Gato gato){
            System.out.printf("Identificador: %d\n Nome: %s\n Idade: %d\n Tamanho: %.2f \n Peso: %.2f \n Possui caixa de areia? %s",
                    gato.getIdentificador(), gato.getNome(), gato.getIdade(), gato.getPeso(), gato.getTraducaoPossuiCaixaDeAreia());
        }
        private static void imprimir(Cachorro cachorro){
            System.out.printf("Identificador: %d\n Nome: %s\n Idade: %d\n Tamanho: %.2f \n Peso: %.2f \n Possui caixa de areia? %s",
                    cachorro.getIdentificador(), cachorro.getNome(), cachorro.getIdade(), cachorro.getPeso(), cachorro.getTraducaoPorssuiCama());
        }
        private static void imprimir(Galinha galinha){
            System.out.printf("Identificador: %d\n Nome: %s\n Idade: %d\n Tamanho: %.2f \n Peso: %.2f \n Possui caixa de areia? %s",
            galinha.getIdentificador(), galinha.getNome(), galinha.getIdade(), galinha.getPeso(), galinha.getTamanhoDoPoleiro());
        }

        private static int deletarAnimais(AnimalDAO dao, Scanner sc){
           Long identificador = Leitor.lerValor("Qual o registro que deseja deletar?", sc, 0L);

           if(identificador > 1){
               Animal a = dao.buscarAnimal(identificador);
               return dao.deletarAnimal(a);
           }
           return 0;
        }

      


        private static ArrayList<Animal> cadastrarAnimal(Scanner sc){
           ArrayList<Animal> animaisParaCadastro = new ArrayList<Animal>();
            Integer op = 0;
            op = Leitor.lerValor("Qual animal deseja cadastrar? \n 1 - Cachorro \n 2 - Gato \n 3 - Galinha", sc, op);
            //Foi utilizado o intValue para melhor performace,  pois os números no case são primitivos.
            switch(op.intValue()){
                case 1:
                    animaisParaCadastro.add(cadastrarCachorro(sc));
                    break;
                case 2:
                    animaisParaCadastro.add(cadastrarGato(sc));
                    break;
                case 3:
                    animaisParaCadastro.add(cadastrarGalinha(sc));
                    break;
                default:
                    break;
            }
            return animaisParaCadastro;
        }

        private static Animal cadastrarCachorro(Scanner sc){
            Cachorro c = new Cachorro();
            c.setIdade(Leitor.lerValor("Qual a idade: ", sc, c.getIdade()));
            c.setNome(Leitor.lerValor("Qual o nome: ", sc));
            c.setPeso(Leitor.lerValor("Qual o peso: ", sc, c.getPeso()));
            c.setTamanho(Leitor.lerValor("Qual o tamanho: ", sc, c.getTamanho()));
            c.setPossuiCama(Leitor.lerValor("Possui cama? ", sc, c.getPossuiCama()));
            return c;
        }

        private static Animal cadastrarGato(Scanner sc){
            Gato g = new Gato();
            g.setIdade(Leitor.lerValor("Qual a idade: ", sc, g.getIdade()));
            g.setNome(Leitor.lerValor("Qual o nome: ", sc));
            g.setPeso(Leitor.lerValor("Qual o peso: ", sc, g.getPeso()));
            g.setTamanho(Leitor.lerValor("Qual o tamanho: ", sc, g.getTamanho()));
            g.setPossuiCaixaDeAreia(Leitor.lerValor("Possui caixa de areia? ", sc, g.getPossuiCaixaDeAreia()));
            return g;
        }

        private static Animal cadastrarGalinha(Scanner sc){
            Galinha gal = new Galinha();
            gal.setIdade(Leitor.lerValor("Qual a idade: ", sc, gal.getIdade()));
            gal.setNome(Leitor.lerValor("Qual o nome: ", sc));
            gal.setPeso(Leitor.lerValor("Qual o peso: ", sc, gal.getPeso()));
            gal.setTamanho(Leitor.lerValor("Qual o tamanho: ", sc, gal.getTamanho()));
            gal.setTamanhoDoPoleiro(Leitor.lerValor("Possui caixa de areia? ", sc, gal.getTamanhoDoPoleiro()));
            return gal;
        }

        //MÉTODO QUE EU FIZ
        // private static Animal cadastrarAnimal(){
        //     Scanner sc = new Scanner(System.in);
        //     ArrayList<Animal> animais = new ArrayList<Animal>();
        //     Integer op = 0;
        //     op = Leitor.lerValor("Qual animal deseja cadastrar? \n 1 - Cachorro \n 2 - Gato \n 3 - Galinha", sc, op);
        //     switch(op){
        //         case 1:
        //             animais.add(new Cachorro());
        //             Leitor.lerValor("Cachorro cadastrado com sucesso!", sc);
        //         case 2:
        //             animais.add((new Gato()));
        //             Leitor.lerValor("Gato cadastrado com sucesso!", sc);
        //         case 3:
        //             animais.add(new Galinha());
        //             Leitor.lerValor("Galinha cadastrado com sucesso!", sc);
        //         default:
        //             break;
        //     }
        //     return null;
        // }
   

}
