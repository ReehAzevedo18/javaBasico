package src;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        // Apresente um texto com as opções “Escolha um número de 1 a 3!” leia a
        // opção. Utilize o switch para verificar qual opção foi escolhida, caso o valor seja
        // 1 chame o método selecionarOpcao1(), caso o valor seja 2 chame o método
        // selecionarOpcao2(), caso o valor seja 3 chame o método selecionarOpcao3()
        System.out.println("Digite o número da opção: \n 1 - Sobre animal \n 2 - Idade do filho(a) \n 3 - Nova opção");
        Opcoes op = new Opcoes();
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

       
        
        switch(opcao){
            case 1:
                op.selecionarOpcao1();
                break;
            case 2:
                op.selecionarOpcao2();
                break;
            case 3: 
                op.selecionarOpcao3();
                break;
            default:
                break;
        }


                                    
        


    }
}
