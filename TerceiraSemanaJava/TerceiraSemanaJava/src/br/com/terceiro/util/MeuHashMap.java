package TerceiraSemanaJava.TerceiraSemanaJava.src.br.com.terceira.util;

import java.util.HashMap;

public class MeuHashMap extends HashMap<Boolean, String> {

    /**
     *
     */
    //Gerado automaticamente por causa da propriedade hashMap
    private static final long serialVersionUID = 1L;

    /*Foi necessário criar uma classe personalizada sobre o HashMap para poder passar dois objetos como retorno,
    pq na propriedade hashMap o normal é retornar somente um objeto */
    public MeuHashMap putCustom(Boolean key, String value) {
        super.put(key, value);
        return this;
    }
}
