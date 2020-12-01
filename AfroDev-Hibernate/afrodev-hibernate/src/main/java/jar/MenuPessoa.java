package jar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.Pessoa;
import br.com.afrodev.hibernate.models.Sexo;
import br.com.afrodev.hibernate.models.dao.PersonalidadeDAO;
import br.com.afrodev.hibernate.models.dao.PessoaDAO;
import br.com.afrodev.hibernate.util.Leitor;

public class MenuPessoa {
    
    /*CRIAR A OPÇÃO DE 1) CADASTRAR 2) TODOS
    Ao cadastrar tem que informar as personalidades e verificar se ela já existe no banco

    PARA CASA
    Imprimir as personalidades junto com a Pessoa
    3) Deletar
    */
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
        EntityManager em = emf.createEntityManager();
        PersonalidadeDAO personalidadeDAO = new PersonalidadeDAO(em);
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        Scanner sc = new Scanner(System.in);
        Integer opcao = 0;
    
        do{
            opcao = Leitor.lerValor("\n1) Cadastrar \n2) Buscar Todos \n3) Deletar \nEscolha uma opção: ", sc, 0);
            System.out.println("\n\n--------------------------------");
    
            switch(opcao.intValue()){
                case 1:
                    em.getTransaction().begin();
                    cadastrar(personalidadeDAO, pessoaDAO, sc);
                    System.out.println("\n\n--------------------------------");
                    em.getTransaction().commit();
                    break;
                case 2:
                    System.out.println("\nTODAS AS PESSOAS");
                    buscarTodos(pessoaDAO);
                    System.out.println("\n\n--------------------------------");
                    break;
                case 3: 
                    em.getTransaction().begin();
                    deletar(pessoaDAO, sc);
                    System.out.println("\n\n--------------------------------");
                    em.getTransaction().commit();
                    break;
                default: 
                    break;
            }
    
        }while(opcao != 0);
    }

    private static void cadastrar(PersonalidadeDAO personalidadeDAO, PessoaDAO pessoaDAO, Scanner sc){
        Pessoa p = new Pessoa();
        p.setNome(Leitor.lerValor("\nQual o nome pessoa?", sc));
        p.setIdade(Leitor.lerValor("\nQual a idade?", sc, 0));
        Sexo sexoEnum = null;

        do{
            String sexo = Leitor.lerValor("Qual o sexo (M/F)? ", sc);
            if(Sexo.FEMININO.getSigla().equals(sexo.toUpperCase())){
                sexoEnum = Sexo.FEMININO;
            }
            if(Sexo.MASCULINO.getSigla().equals(sexo.toUpperCase())){
                sexoEnum = Sexo.MASCULINO;
            }
        }while(sexoEnum == null);
        p.setSexo(sexoEnum);

        List<Personalidade> personalidades = new ArrayList<Personalidade>();

        Integer controleAdicionandoPersonalidade = 0;
        do{
            Boolean querAdicionarPer = Leitor.lerValor("Deseja adicionar uma personalidade a pessoa?", sc, false);
            if(querAdicionarPer){
                String nome = Leitor.lerValor("Informe o nome da personalidade: ", sc);
                Personalidade personalidade = MenuPersonalidade.buscarPorNomeExato(personalidadeDAO, sc);

                if(personalidade != null){
                    personalidades.add(personalidade);
                }else{
                    Personalidade novaPersonalidade = new Personalidade(nome);
                    personalidadeDAO.salvar(novaPersonalidade);
                    personalidades.add(novaPersonalidade);
                }
            }
        }while(controleAdicionandoPersonalidade != 0);

        p.setPersonalidades(personalidades);
        pessoaDAO.salvar(p);
      
    }

    private static void buscarTodos(PessoaDAO pessoaDAO){
        List<Pessoa> pessoas = pessoaDAO.consultarTodos();
        // pessoas = pessoaDAO.consultaPessoaEPersonalidade();
        pessoas.forEach(pessoa -> {
            System.out.println(pessoa);
        });
    }

    private static Pessoa deletar(PessoaDAO pessoaDAO, Scanner sc){
        Pessoa p = buscarPessoa(pessoaDAO, sc);
        if(p != null){
            pessoaDAO.deletar(p);
            System.out.println("Pessoa deletada com sucesso!");
        }        
        return p;
    }

    private static Pessoa buscarPessoa(PessoaDAO pessoaDAO, Scanner sc){
        Integer opcao = 0;
        Pessoa p = null;

        do{
            opcao = Leitor.lerValor("\n1) Buscar por nome \n 2) Buscar por Identificador: \nEscolha uma opção: ", sc, 0);
            switch(opcao.intValue()){
                case 1:
                    p = buscarPorNome("\nQual o nome da pessoa que deseja excluir? ",pessoaDAO, sc);
                        if(p == null){
                            System.out.println("Não localizamos pessoas com esse nome, tente novamente!");
                        }
                    break;
                case 2:
                    p = buscarPorId(pessoaDAO, sc);
                        if(p == null){
                            System.out.println("Não localizamos pessoas com esse ID, tente novamente!");
                        }
                    break;
            }
        }while(opcao != 0);

        return p;
    }
    
    private static Pessoa buscarPorNome(String pergunta,PessoaDAO pessoaDAO, Scanner sc){
        List<Pessoa> pessoas = pessoaDAO.consultarPorNome(Leitor.lerValor("\nInforme a parte do nome para buscar a pessoa: ", sc));
                
        if(pessoas.size() == 1){
            return pessoas.get(0);
        }else if(pessoas.size() > 1){
            System.out.println("Há mais de uma pessoa com esse nome!");
            pessoas.forEach(pessoa -> {
                System.out.println(pessoa);
            });

            Long id = Leitor.lerValor("\nQual o identificador da Pessoa que deseja selecionar?", sc, 0L);
            Pessoa selecionado = null;

            for(int i = 0; i < pessoas.size(); i++){
                if(id.equals(pessoas.get(i).getIdt())){
                    selecionado = pessoas.get(i);
                }
            }
            return selecionado;
        }else {
                return null;
            }

        
    }

    private static Pessoa buscarPorId(PessoaDAO pessoaDAO, Scanner sc){
        return pessoaDAO.consultarPorIdt(Leitor.lerValor("\nQual o identificador da pessoa?", sc, 0L));
    }
 

   
    
}
