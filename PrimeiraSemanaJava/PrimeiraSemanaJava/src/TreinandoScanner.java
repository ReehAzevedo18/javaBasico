package PrimeiraSemanaJava.PrimeiraSemanaJava.src;

import java.util.Scanner;

public class TreinandoScanner {

    public static void main(String[] args){
        /*Crie um programa que leia o seu 
    String nome
    int idade
    float peso */

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        String nome = sc.nextLine();
        // System.out.println("Meu nome é: " +nome);

        System.out.println("Informe sua idade: ");
        int idade = sc.nextInt();
        // System.out.println("Minha idade é: " +idade);

        System.out.println("Informe seu peso: ");
        float peso = sc.nextFloat();
        // System.out.printf("Meu peso é: " +peso);

        verificaIdadeEPeso(peso, idade, nome);
        verificaIdadeComSwitch(idade);
        verificaPesoComWhile(peso);
        
    }

    public static void verificaIdadeEPeso(float peso, int idade, String nome){
              // && testa se duas condições são verdadeiras, caso sejam retorna true
        /*|| testa se uma das condições é verdadeira, caso seja retorna true
        ! nga o booleano !true = false */
        String mensagem = "Resultado do if de idade e peso: ";

        if((peso > 80 && idade > 40) || nome.equals("Marcus")){
           System.out.println(mensagem+ "Você precisa correr mais.");
       }else{
           System.out.println(mensagem+ "Coma mais carboidrato!");
        }
    }

    public static void verificaIdadeComSwitch(int idade){
         // Switch - funciona apenas para inteiro
         String mensagem = "Resultado do switch de idade: ";
         switch(idade){
            case 40:
                System.out.println(mensagem+ "Ele(a) tem 40 anos!");
                break;
            default:
               System.out.println(mensagem+ "Você deve ser novo ou velho!"); 
                break;
        }
    }
   
     public static void verificaPesoComWhile(float peso){
         while(peso < 3){
             peso++;
         }
     }

     /*Adicione toda a cadeia de codigo que criamos 
     em uma estrutura while enquanto o valor de controle for "C" */
    //  String controle = "C";

    //  while(controle.equals("C")){
    //     if(!controle.equals("C")){
    //         break;
    //     }
    //  }
}

