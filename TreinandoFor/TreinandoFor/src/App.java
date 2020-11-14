import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*Verificar se uma sring tem o tamanho maior que 10 usando o for */
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String texto = sc.nextLine();
        
        /*Selecionando e Mostrando o caractere */
        System.out.println(texto.substring(0,1)); 

        String textoDeSplit = "Renata, Marcus, Janaina, Sam";
        String[] nomes = textoDeSplit.split(",");
        //É o foreach do C# porém em algumas versões tem algumas diferenças.
        for(String i : nomes){
            System.out.println(i);
        }

        for(int i=0; i < texto.length(); i++){
            if(i == 8){
                System.out.println("Essa palavra "+texto+" tem "+texto.length()+ " caracteres!");
            }
            texto.substring(i, (i+1));

             /*Quando a string tiver a letra a pule 2 caracteres se possivel */
             if(texto.substring(i, (i + 1)).toLowerCase().equals("a")
                    && (i+2) < texto.length()){
                        i = i+2;
                    }   
                
        }

        // for(int i=0; i < texto.length(); i++){
        //     if(i == 8){
        //         System.out.println("Essa palavra "+texto+" tem "+texto.length()+ " caracteres!");
        //     }
        //     texto.substring(i, (i+1));

        //      /*Quando a string tiver a letra a pule 2 caracteres se possivel */
        //      if(texto.split("a").toLowerCase()
        //             && (i+2) < texto.length()){
        //                 i = i+2;
        //             }   
                
        // }

        String[] nomesSplit = textoDeSplit.split("");
        int controleAchouA = 0;
        //Foreach
        for(String a: nomesSplit){
          if (controleAchouA == 0){
              System.out.println(a);
          }
          else {
              controleAchouA--;
          }
          if(a.toLowerCase().contains("a")){
              controleAchouA = 2;
          }
        }

        //Propriedades break e continue
        //Continue é para quando é necessário percorrer todos os arrays, antes de ir para a proxima etapa, que no caso é imprimir na tela a frase Não encontrei um b
        for(String a: nomesSplit){
            if(a.toLowerCase().contains("b")){
                controleAchouA = 2;
                continue;
            }
            System.out.println("Não encontrei um b");
          }

        //para quando for necessário não percorrer todos os arrays, assim que localizado o que precisa ele irá sair da função.
        for(String a: nomesSplit){
            if(a.toLowerCase().contains("b")){
                controleAchouA = 2;
                break;
            }
            System.out.println("Não encontrei um b");
          }

       
       
        

    }
}
