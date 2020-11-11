public class Calculadora {

    int valorPadraoMultiplicacao = 2;
    //Float eu consigo atribuir um valor inteiro
    float valorPadraoSoma = 3.3f;

    //Forçando a conversão para inteiro
    int valorPadraoSomaInteiro = (int) 3.4f;

    public int realizarMultiplicacao(int valor){
        return valor * this.valorPadraoMultiplicacao;
    }

    public float realizarSoma(float valor){
        return valor * this.valorPadraoSoma;
    }
}