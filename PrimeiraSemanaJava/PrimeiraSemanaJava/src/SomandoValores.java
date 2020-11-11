public class SomandoValores {

    // Informar dois valores e relaizar a soma
    // de ambons e apresentar o resultado da seguinte forma:
    // "valor1 + valor2 = soma"

    public static void main(String[] args){
        int val1 = 1;
        int val2 = 4;
        boolean ehMaior = false;
        String mensagem = "Ocorreu um ajuste no valor da soma já que ";

        soma = val1 + val2;
    
        // System.out.println(val1+" + "+val2+" = "+soma);
        System.out.println(("") + val1).concat(" + " + val2).concat(" = "+ soma);
    
        // Quando o val1 for maior que o val2
        // some + 2 ao valor da soma
    
        if(val1 > val2){
            soma = soma + 2;
            System.out.println(("O valor 1 é maior que o valor 2: ") + soma);
            ehMaior = true;
        }
        //quando o val1 for menor que o val2 diminua - 5 ao valor da soma
        else if(val1 < val2){
            soma = soma - 5;
        }
        System.out.println(("O valor 1 é menor que o valor 2: ") + soma);

        //Ocorreu um ajuste no valor da soma já que va1 > va2 
        // val1 < val2
        // if(ehMaior){
        //     System.out.println(mensagem.concat("" +val1).concat(" > ").concat("" +val2));
        // }else{
        //     System.out.println(mensagem.concat("" +val1).concat(" < ").concat("" +val2));
        // }
        
        //IF ternário
        System.out.println(mensagem.concat("" +val1).concat(ehMaior ? " > " : " < ").concat("" +val2));
            
    }
   
}