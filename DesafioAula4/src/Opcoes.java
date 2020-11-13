package src;

import java.util.Scanner;

public class Opcoes {

    // Crie 3 métodos: selecionarOpcao1(), selecionarOpcao2() e selecionarOpcao3()

    // b. No método selecionarOpcao1() faça a seguinte pergunta - “Qual o nome do
    // seu animal preferido?”, após informar o nome do animal preferido realize uma
    // verificação. Se o animal for igual a “Gato” você deve imprimir – “Quem legal o
    // meu também”, caso não seja imprima “Eu prefiro gato..” e refaça a pergunta
    // até que o valor de animal seja “Gato”. Dica: utilize while e a Classe Scanner.

    // c. No método selecionarOpcao2() faça a seguinte pergunta – “Qual a idade do
    // seu filho?”, se a idade for maior que 0 e menor que 12 anos imprima – “Ele
    // ainda é uma criança”, se a idade for maior que 11 e menor que 19 imprima –
    // “Adolescência é fogo.. ”, se a idade for maior que 18 imprima – “Ele já é um
    // adulto!”. Dica: um if nunca é demais.

    // d. No método selecionarOpcao3() você irá somente imprimir “Em construção ...
    // será que vamos aprender a usar o for.. ”

    Scanner sc = new Scanner(System.in);
    
    public void selecionarOpcao1(){
        String animal = "";
        String comAnimal = "Que legal o meu também!";
        String semAnimal = "Eu prefiro gato..";
        
        while(!animal.equals("Gato")){
            System.out.println("Qual o nome do seu animal preferido?");
            animal = sc.nextLine();
            
            if(!animal.equals("Gato"))
                Impressora.imprimaValor(semAnimal);
        }

        if(animal.equals("Gato"))
            Impressora.imprimaValor(comAnimal);
      
    }

    public void selecionarOpcao2(){
        String msgMenor12 = "Ele ainda é uma criança";
        String msgMaior11 = "Adolescência é fogo.. ";
        String msgMaior18 = "Ele já é um adulto!";

        System.out.println("Qual a idade do seu filho?");
        int idade = sc.nextInt();
        if(idade > 0 && idade < 12){
            Impressora.imprimaValor(msgMenor12);
        }else if(idade > 11 && idade < 19){
            Impressora.imprimaValor(msgMaior11);
        }else{
            Impressora.imprimaValor(msgMaior18);
        }
    }

    public void selecionarOpcao3(){
        String mensagem = "Em construção ...";
        Impressora.imprimaValor(mensagem);
    }


}
