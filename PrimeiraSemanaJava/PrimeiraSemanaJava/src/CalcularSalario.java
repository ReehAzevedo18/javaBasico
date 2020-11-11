public class CalcularSalario{

    public static void main(String[] args){


        //Informem 2 valores do tipo float
        // 1 valor é salario base
        // 2 valor é o total de vendas
        // Apresentar valor do salario + comissao que representa 10% do valor da venda

        float salario_base, total_vendas, novo_salario, val_comissao;
        float comissao = 0.10;

        val_comissao = (total_vendas * comissao);
        novo_salario = salario_base + val_comissao;

        System.out.println("O salário final é "+novo_salario);


    }
}