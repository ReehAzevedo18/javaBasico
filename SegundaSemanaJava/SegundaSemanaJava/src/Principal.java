import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int tam = lerValor("Qual o tamanho do array?", sc, 0);

    // Pessoa pessoa = new Pessoa();
    // pessoa.setNome("Marcus");
    //CRIE UM ARRAY DE PESSOAS E PASSAR A UTILIZA-LO NO PROGRAMA
    
    Pessoa[] p = new Pessoa[tam];
    // String[] nomes = new String[tam];
    // float[] pesos = new float[tam];
    // char[] sexos = new char[tam];
    int opcao = 0;
    int nRegistro = 0;
  
    do{
        opcao = lerValor("Escolha uma opção de 1 à 5:", sc, opcao);
       

        switch  (opcao){
            case 0: 
                System.out.println("Saindo ...");
                break;
            case 1:
                for(int i=0; i < tam; i++){
                    Pessoa pConsulta = p[i];
                    if(pConsulta != null){
                        System.out.printf("Nome: %s \n",pConsulta.getNome());
                        System.out.printf("Peso: %s \n",pConsulta.getPeso());
                        System.out.printf("Sexo: %s \n",pConsulta.getSexo());
                    }
                }
                break;
        
            case 2:
            for(int i=0; i <= tam; i++){
                System.out.printf("Registro n° %d \n ", (i + 1));
                p[i] = adicionarValorArray(p[i], sc);
                }
                break;
            case 3:
                nRegistro = lerValor("Informe o n° do registro para alteração:", sc, nRegistro);
                p[nRegistro - 1] = adicionarValorArray(p[nRegistro - 1],sc);
                break;

            case 4:
                nRegistro = lerValor("Informe o n° do registro para alteração:", sc, nRegistro);
                int tipoRegistro = lerValor("Qual informação deseja alterar: 1 - Nome /n 2 - Peso /n 3 - Sexo ", sc, 0);                
                          
                p[nRegistro -1] = adicionarValorArray(p[nRegistro - 1],tipoRegistro, sc);

             
                break;
            case 5:
       
                System.out.println("Informe o n° do registro para mostrar seus dados: ");
                nRegistro = sc.nextInt();
                System.out.println("Nome: "+p[nRegistro - 1].getNome());
                System.out.println("Peso: "+p[nRegistro - 1].getPeso());
                System.out.println("Sexo: "+p[nRegistro - 1].getSexo());
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }while(opcao != 0);

    }

  
    private static Pessoa adicionarValorArray(Pessoa p, Scanner sc) {
        if(p == null){
            p = new Pessoa();
        }
            // p.setNome(lerValor("Informe seu nome: ", sc));
            p.setPeso(lerValor("Informe seu peso:", sc, p.getPeso()));
            p.setSexo(lerValor("Informe o sexo (F/M): ", sc, p.getSexo()));
            return p;
    }

 
    
    private static Pessoa adicionarValorArray(Pessoa p,int tipoRegistro, Scanner sc){

        if(p == null){
            p = new Pessoa();
        }
        if(tipoRegistro == 1){
            p.setNome(lerValor("Informe seu nome:", sc));
            System.out.println("Nome alterado com sucesso!");
        }else if(tipoRegistro == 2){
            p.setPeso(lerValor("Informe seu peso:", sc, p.getPeso()));
            System.out.println("Peso alterado com sucesso!");
        }else if(tipoRegistro == 3){
            p.setSexo(lerValor("Informe seu sexo (F/M):", sc, p.getSexo()));
            System.out.println("Sexo alterado com sucesso!");
        }

        return p;
    }

     //Vamos abstrair
     public static String lerValor(String pergunta, Scanner sc){
        System.out.println(pergunta);
            return sc.next();
    }

    //Sobrecarga de métodos
    public static Float lerValor(String pergunta, Scanner sc, Float valor){
        System.out.println(pergunta);
        return sc.nextFloat();
    }

    public static Integer lerValor(String pergunta, Scanner sc, Integer valor){
        System.out.println(pergunta);
        return sc.nextInt();
    }

    public static Character lerValor(String pergunta, Scanner sc, Character valor){
        System.out.println(pergunta);
        String retorno = sc.next();
        return retorno.charAt(0);
    }

 
}
