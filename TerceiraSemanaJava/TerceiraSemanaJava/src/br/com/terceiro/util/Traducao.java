package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira.util;

import java.util.HashMap;

public class Traducao {
    //Através do hash eu consigo substituir um valor de uma propriedade por algo que eu queira mostrar na tela
    
    //Foi criada um atributo da variavel hashMap para atribuir o método putCustm que está recebendo esse dois objetos
    private static HashMap<Boolean, String> hashMap = new MeuHashMap().putCustom(true, "Sim").putCustom(false, "Não");
    
    public static String traduzir(Boolean b){
        return hashMap.get(b);
	
    }
}
