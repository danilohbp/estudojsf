package com.estudojsf.controle;

import com.estudojsf.entidade.Automovel;
import com.estudojsf.util.JPAUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author danilohbp
 */
@ManagedBean
public class AutomovelBean {

    private Automovel automovel = new Automovel();

    private List<Automovel> automoveis;

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public List<Automovel> getAutomoveis() {
        if (this.automoveis == null) {
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("SELECT a from Automovel a", Automovel.class);
            this.automoveis = q.getResultList();
            em.close();
        }
        return automoveis;
    }

    public void salva() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(automovel);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Automovel automovel){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        automovel = em.merge(automovel);
        em.remove(automovel);
        tx.commit();
        em.close();
    }
}
