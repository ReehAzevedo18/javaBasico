package jar;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.dao.PersonalidadeDAO;
import br.com.afrodev.hibernate.util.Leitor;

public class MenuPersonalidade {

    public static void main(String[] args){

         //Criar a opção de 1) Cadastrar, 2) Editar, 3) Deletar e 4) Buscar por nome
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
        EntityManager em = emf.createEntityManager();
        PersonalidadeDAO personalidadeDAO = new PersonalidadeDAO(em);
        Scanner sc = new Scanner(System.in);
        Integer opcao = 0;

        do{
            opcao = Leitor.lerValor("1) Cadastrar \n2) Editar \n3) Deletar \n4) Buscar por nome \n 5) Buscar Todos \nEscolha uma opção: ", sc, 0);
            System.out.println("\n\n--------------------------------");
            switch(opcao.intValue()){
                case 1:
                    em.getTransaction().begin();
                    cadastrar(personalidadeDAO, sc);
                    System.out.println("\n\n--------------------------------");
                    em.getTransaction().commit();
                    break;
                case 2:
                em.getTransaction().begin();
                    editar(personalidadeDAO, sc);
                    System.out.println("\n\n--------------------------------");
                    em.getTransaction().commit();
                    break;
                case 3:
                    em.getTransaction().begin();
                    deletar(personalidadeDAO, sc);
                    System.out.println("\n\n--------------------------------");
                    em.getTransaction().commit();
                    break;
                case 4: 
                    Personalidade  per = buscarPorNome("\nQual o identificador da personalidade deseja selecionar? ", personalidadeDAO, sc);
                    System.out.println( per == null ? "Não encontrado!" : per);
                    break;
                case 5:
                    buscarTodos(personalidadeDAO);
                    System.out.println("\n\n--------------------------------");
                    break;
                default:
                    break;
            }
        }while(opcao != 0);

    }

    private static void buscarTodos(PersonalidadeDAO personalidadeDAO){
        List<Personalidade> personalidades = personalidadeDAO.consultarTodos();
        personalidades.forEach(personalidade -> {
            System.out.println(personalidade);
        });
    }

    private static void cadastrar(PersonalidadeDAO personalidadeDAO, Scanner sc){
        Personalidade p = new Personalidade();
        p.setNome(Leitor.lerValor("\nQual o nome da nova personalidade?", sc));
        personalidadeDAO.salvar(p);
    }

    private static Personalidade deletar(PersonalidadeDAO personalidadeDAO, Scanner sc){
        Personalidade p = buscarPersonalidade(personalidadeDAO, sc);
        if(p != null){
            personalidadeDAO.deletar(p);
        }
        return p;
    }

    private static void editar(PersonalidadeDAO personalidadeDAO, Scanner sc){
        Personalidade p = buscarPersonalidade(personalidadeDAO, sc);

        if(p != null){
            String nome = Leitor.lerValor("\nQual o novo nome da personalidade? ", sc);
            p.setNome(nome == null || nome.trim().equals("") ? p.getNome() : nome);
            personalidadeDAO.salvar(p);
        }

    }

    private static Personalidade buscarPersonalidade(PersonalidadeDAO personalidadeDAO, Scanner sc){
        Integer opcaoDeBusca = 0;
        Personalidade p = null;
        do{

            opcaoDeBusca = Leitor.lerValor("\n1) Buscar por nome \n 2) Buscar por Identificador: ", sc, 0);
            switch(opcaoDeBusca.intValue()){
                case 1:
                    p = buscarPorNome("\nQual o nome da personalidade ? ",personalidadeDAO, sc);
                    break;
                case 2:
                    p = buscarPorIdentificador(personalidadeDAO, sc);
                    if(p == null){
                        System.out.println("Nenhum registro encontrado");
                    }
                    break;
            }

        }while(opcaoDeBusca != 0);

        return p;

    }
   
    private static Personalidade buscarPorIdentificador(PersonalidadeDAO personalidadeDAO, Scanner sc){
        return personalidadeDAO.consultarPorIdt(Leitor.lerValor("\nQual o identificador da personalidade?", sc, 0L));

    }

    private static Personalidade buscarPorNome(String pergunta,PersonalidadeDAO personalidadeDAO, Scanner sc){
        List<Personalidade> personalidades = personalidadeDAO.consultarPorPersonalidade(Leitor.lerValor("\nInforme a parte do nome para buscar a personalidade: ", sc));

        if(personalidades.size() == 1){
            return personalidades.get(0);
        }else if(personalidades.size() > 1){
            System.out.println("Foram encontrados esses registros: ");
            personalidades.forEach(personalidade -> {
                System.out.println(personalidade);
            });
            
            Long identificador = Leitor.lerValor("\nQual o identificador da Personalidade deseja selecionar para edição ?", sc, 0L);
            Personalidade selecionado = null;

            for(int i = 0; i < personalidades.size(); i++){
                if(identificador.equals(personalidades.get(i).getIdt())){
                    selecionado = personalidades.get(i);
                }
            }
            return selecionado;
        }else{
            return null;
        }
    }

    public static Personalidade buscarPorNomeExato(PersonalidadeDAO personalidadeDAO, Scanner sc){
        Personalidade personalidade = personalidadeDAO.consultarPorNomeExato(Leitor.lerValor("Informe a parte do nome para buscar a personalidade: ", sc));
        return personalidade;
    }

}
