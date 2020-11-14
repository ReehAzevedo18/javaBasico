package src;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        // Apresente um texto com as opções “Escolha um número de 1 a 3!” leia a
        // opção. Utilize o switch para verificar qual opção foi escolhida, caso o valor seja
        // 1 chame o método selecionarOpcao1(), caso o valor seja 2 chame o método
        // selecionarOpcao2(), caso o valor seja 3 chame o método selecionarOpcao3()
        
      
        Scanner sc = new Scanner(System.in);
        int escolha;
        Opcoes op = new Opcoes();
        int idade = 0;

        do{

              /*Quando a idade ainda não tiver sido informada
         e entrarem na opção 3 imprima 
         "É necessário informar a idade  na opção 2 e não executa o código da opção 2" */
            
         /*Retorne a idade da opção 2 e atribua o valor a variavel idade da classe Menu */
            escolha = escolhaOpcao(sc);
            switch(escolha){
                case 1:
                    op.selecionarOpcao1();
                    break;
                case 2:
                    idade = op.selecionarOpcao2();
                    break;
                case 3: 
                op.selecionarOpcao3(idade);

                    break;
                default:
                    Impressora.imprimaValor("Você não selecionou um valor!");
                    break;
            }
        }while(escolha != 0);

      
       
    }

    public static int escolhaOpcao(Scanner sc){
        System.out.println("Digite o número da opção: \n 1 - Sobre animal \n 2 - Idade do filho(a) \n 3 - Nova opção");
        return sc.nextInt();
    }
}
