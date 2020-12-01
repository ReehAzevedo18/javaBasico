package br.com.afrodev.hibernate.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.idao.IPersonalidadeDAO;

public class PersonalidadeDAO implements IPersonalidadeDAO {

    private EntityManager em;
    //Dentro do select, será colocado o nome da classe e não o nome da tabela
    private static String SQLCONSULTAPORNOME = "SELECT p FROM Personalidade WHERE p.nome like :pNome ";
    private static String SQLCONSULTARTODOS = "SELECT p FROM Personalidade p";

    public PersonalidadeDAO(EntityManager em){
        this.em = em;
    }

    @Override
    public void salvar(Personalidade p) {
        this.em.persist(p);

    }
    
    @Override
    public void deletar(Personalidade p) {
       
        this.em.remove(p);
    }

    @Override
    public List<Personalidade> consultarPorPersonalidade(String personalidade) {
        TypedQuery<Personalidade> q = em.createQuery(this.SQLCONSULTAPORNOME, Personalidade.class);
        q.setParameter("pNome", personalidade);
        List<Personalidade> personalidades = q.getResultList();
        return personalidades;
    }

    @Override
    public Personalidade consultarPorIdt(Long idt) {
        return this.em.find(Personalidade.class, idt);
    }

   

    @Override
    public List<Personalidade> consultarTodos(){
        TypedQuery<Personalidade> q = em.createQuery(this.SQLCONSULTARTODOS, Personalidade.class);
        List<Personalidade> personalidades = q.getResultList();
        return personalidades;
    }

    private static String SQLCONSULTARPORNOMEEXATO = "Select p from Personalidade p where p.nome = :pNome ";
    @Override
    public Personalidade consultarPorNomeExato(String nome){

        TypedQuery<Personalidade> q = em.createQuery(this.SQLCONSULTARPORNOMEEXATO, Personalidade.class);
        q.setParameter("pNome", nome);
        Personalidade personalidade = null;
        List<Personalidade> personalidades = q.getResultList();

        if(personalidades.size() == 1){
            personalidade = personalidades.get(0);
        }
        return personalidade;
    }
}
