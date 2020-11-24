package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira.util;
import java.util.Scanner;

public class Leitor {
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

    public static Boolean lerValor(String pergunta, Scanner sc, Boolean b){
        String retorno = "";
        do{
            System.out.println(pergunta);
            retorno = sc.next();
        }while(!retorno.toUpperCase().equals("SIM") || !retorno.toUpperCase().equals("NAO"));
        if(retorno.toUpperCase().equals("SIM")){
            return true;
        }else{
            return false;
        }
    }

    public static Long lerValor(String pergunta, Scanner sc, Long valor){
        System.out.println(pergunta);
        Long retorno = sc.nextLong();
        return retorno;
    }
    
}
