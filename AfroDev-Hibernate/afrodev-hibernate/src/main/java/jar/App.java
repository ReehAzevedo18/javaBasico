package jar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.Pessoa;
import br.com.afrodev.hibernate.models.Sexo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        //Gerenciador de entidades, as classes que serão geradas automaticamentes foram informadas no xml persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
        EntityManager em = emf.createEntityManager();

        //Abrindo a conexão 
        em.getTransaction().begin();

        //Instancio a pessoa em objeto, settei os valores de alguns parametros
        Pessoa p = new Pessoa();
        p.setNome("Renatinha");
        p.setIdade(25);
        p.setSexo(Sexo.MASCULINO);
        List<Personalidade> personalidades = new ArrayList<>();

        //Adicionei uma nova personalidade para essa pessoa
        personalidades.add(new Personalidade("Extrovertido"));
        personalidades.add(new Personalidade("Reservado"));
        for(int i=0; i < personalidades.size(); i++){
            em.persist(personalidades.get(i));
        }


        p.setPersonalidades(personalidades);
        //Persistindo no banco
        em.persist(p);
        //Dando commit, uma fez feito, não tem como ser desfeito
        em.getTransaction().commit();


        //Nesse caso eu realizo uma consulta informando o script
        //Em JPA, a gente nomeia o paramentro da seguinte forma = :pNOMEDAVARIAVEL
        Query q = em.createQuery("SELECT p FROM PESSOA WHERE p.nome = :pNome ", Pessoa.class);
        q.setParameter("pNome", "Mariazinha");
        //Como retornara uma lista, é necessário criar um list
        List<Pessoa> pessoas = q.getResultList();

        for(Pessoa pessoa : pessoas){
            System.out.println(p);
        }

        //Fecha a consulta 
        em.close();




    }
}
