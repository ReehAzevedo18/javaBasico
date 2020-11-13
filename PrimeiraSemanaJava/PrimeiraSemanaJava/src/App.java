package PrimeiraSemanaJava.PrimeiraSemanaJava.src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Calculadora c = new Calculadora();

        System.out.println(c.realizarMultiplicacao(10));
        System.out.println(c.realizarSoma(10));
        // System.out.println(c.valorPadraoSoma());

        //Tipos de dados
        byte b; //utilizado para ler arquivo ou verificar se existe modificações em uma classe
        short s; //menor que o byte, tamanho: -32000 até 320000
        int i; 
        long l;
        float f;
        double d;
        boolean bol; //verdadeiro ou falso
        char ch = 50; //caractere
        System.out.println(ch);

        Scanner sc = new Scanner(System.in);
        float numF = sc.nextFloat();
        System.out.println(numF);
        int numI = sc.nextInt();
        System.out.println(numI);
        byte byte1 = sc.nextByte();
        System.out.println(byte1);
        long lg1 = sc.nextLong();
        System.out.println(lg1);
        boolean b1 = sc.nextBoolean();
        System.out.print(b1);
        double num2 = sc.nextDouble();
        System.out.println(num2);
        String nome = sc.nextLine();
        System.out.println(nome);


    }
}
