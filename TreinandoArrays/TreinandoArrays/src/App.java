import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

    String[] nomes = {"Marcus","Renata","Janaina","Patricia","Samuel"};
    int[] idades = {10, 20, 30, 40, 50};

    Scanner sc = new Scanner(System.in);
    String nome;
   
    //Imprima a idade e o nome percorrendo os arrays
    for(int i=0; i < nomes.length; i++){
        System.out.println("Seu nome é "+nomes[i]+" e sua idade é "+idades[i]);
    }

    //Altere os valores  dos nomes das posições pares utilizando array[posicao] = valor;
    //Lembre-se de usar o scanner
    for(int i=0; i < nomes.length; i++){
        if(i % 2 == 0){
            System.out.println("O nome "+nomes[i]+" está sendo alterado!");
            nome = sc.nextLine();
            nomes[i] = nome;
            System.out.println("Foi alterado para: "+nome);
        }
        i++;
    }

        //Altere os valores  dos nomes das posições impares utilizando array[posicao] = valor;
    //Lembre-se de usar o scanner
    for(int i=0; i < nomes.length; i++){
        if(i % 2 != 0){
            nome = sc.nextLine();
            nomes[i] = nome;
        }
        i++;
    }

    }
}
