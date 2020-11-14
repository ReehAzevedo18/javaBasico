import java.util.Scanner;

public class DesafioAula06 {

    public static String lerValor(String pergunta, Scanner sc){
        System.out.println(pergunta);
            return sc.next();
    }

    //Sobrecarga de métodos
    public static int lerValor(String pergunta, Scanner sc, float valor){
        System.out.println(pergunta);
        return sc.nextInt();
    }

    public static char lerValor(String pergunta, Scanner sc, char valor){
        System.out.println(pergunta);
        String retorno = sc.next();
        return retorno.charAt(0);
    }

    public static void main(String[] args){
          ///Crie tres arrays com seis posições 
   //Primeiro array com nomes (string)
    //Segundo array com peso (float)
    //Terceiro array com sexo (char) F // M
     

      //  String[] nomes = {"","","","","",""};
    //  float pesos[] = {0,0,0,0,0,0};
    //  char sexos[] = {'N','N','N','N','N','N'};

    Scanner sc = new Scanner(System.in);
    int tam = lerValor("Qual o tamanho do array?", sc, 0);

    String[] nomes = new String[tam];
    float[] pesos = new float[tam];
    char[] sexos = new char[tam];
    int opcao = 0;
    int nRegistro = 0;
   

     //Definir o tamanho dos arrays com base de uma entrada
    //Crie um menu usando o switch com as opções do tipo (1 a 3):
    //1 - ApresentarTodosOsValoresPorArray
    //2 - AlterarTodoArray
    //3 - AlterarArrayPorPosicao 
    
    
    do{
        opcao = lerValor("Escolha uma opção de 1 à 5:", sc, opcao);
        opcao = sc.nextInt();

        switch  (opcao){
            case 0: 
                System.out.println("Saindo ...");
            case 1:
                for(int i=0; i < tam; i++){
                    System.out.printf("Nome: %s \n",nomes[i]);
                    System.out.printf("Peso: %s \n",pesos[i]);
                    System.out.printf("Sexo: %s \n",sexos[i]);
                }
                break;
        
            case 2:
            for(int i=0; i <= tam; i++){
                System.out.printf("Registro n° %d \n ", (i + 1));
                //Criado um método para receber os dados que serão inseridos no array
                adicionarValorArray(nomes, pesos, sexos, i, sc);

                //Para exemplo, foi criado um método onde os parametros de entrada são uma string e o SC da biblioteca scanner
                // nomes[i] = lerValor("Informe o nome", sc); 
                // System.out.println("informe seu peso:");
                // pesos[i] = sc.nextFloat();
                
                //O tipo Char não possui propriedade na biblioteca Scanner, então nesse caso a gente converte para string e depois quando for usar o scanner converte para char
                // System.out.println("informe seu sexo:");
                // String sexo = sc.next();
                // sexos[i] = sexo.charAt(0);
                }
                break;
            case 3:
                nRegistro = lerValor("Informe o n° do registro para alteração:", sc, nRegistro);
                //Caso queira utilizar dessa forma, também pode
                adicionarValorArray(nomes,pesos, sexos, (nRegistro - 1),sc);
                // nomes[nRegistro - 1] = lerValor("Informe seu nome:", sc);
                // pesos[nRegistro - 1] = lerValor("Informe seu peso:", sc, pesos[nRegistro - 1]);
                // sexos[nRegistro - 1] = lerValor("Informe seu sexo (F/M):", sc, sexos[nRegistro - 1]);
                break;

            case 4:
                nRegistro = lerValor("Informe o n° do registro para alteração:", sc, nRegistro);
                int tipoRegistro = lerValor("Qual informação deseja alterar: 1 - Nome /n 2 - Peso /n 3 - Sexo ", sc, 0);                
                          
                adicionarValorArray(nomes, pesos, sexos, (nRegistro -1),tipoRegistro, sc);

             
                break;
            case 5:
                //Imprimir valores por registro
                System.out.println("Informe o n° do registro para alteração: ");
                nRegistro = sc.nextInt();
                System.out.println("Nome: "+nomes[nRegistro - 1]);
                System.out.println("Peso: "+pesos[nRegistro - 1]);
                System.out.println("Sexo: "+sexos[nRegistro - 1]);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }while(opcao != 0);

    }

    //Metodo privado, será usado apenas dentro dessa classe 
    private static void adicionarValorArray(String[] nomes, float[] pesos, char[] sexos, int i, Scanner sc) {
            nomes[i] = lerValor("Informe seu nome: ", sc);
            pesos[i] = lerValor("Informe seu peso: ", sc, pesos[i]);
            sexos[i] = lerValor("Informe o sexo (F/M): ", sc, sexos[i]);
    }

 
    //Criem mais uma sobrecarga do método adicionarValorArray para a opção 4
    private static void adicionarValorArray(String[] nomes, float[] pesos, char[] sexos, int nRegistro,int tipoRegistro, Scanner sc){
        if(tipoRegistro == 1){
            nomes[nRegistro - 1] = lerValor("Informe seu nome:", sc);
            System.out.println("Nome alterado com sucesso!");
        }else if(tipoRegistro == 2){
            pesos[nRegistro - 1] = lerValor("Informe seu peso:", sc, pesos[nRegistro - 1]);
            System.out.println("Peso alterado com sucesso!");
        }else if(tipoRegistro == 3){
            sexos[nRegistro - 1] = lerValor("Informe seu sexo (F/M):", sc, sexos[nRegistro - 1]);
            System.out.println("Sexo alterado com sucesso!");
        }
    }
 
}

