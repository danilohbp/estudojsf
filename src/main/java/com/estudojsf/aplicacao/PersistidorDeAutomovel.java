package com.estudojsf.aplicacao;

import com.estudojsf.entidade.Automovel;
import com.estudojsf.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author danilohbp
 */
public class PersistidorDeAutomovel {

    public static void main(String[] args) {
//        excluir();
        inserir();
    }

    public static void inserir() {
        EntityManager em = JPAUtil.getEntityManager();

        Automovel auto = new Automovel();
        auto.setMarca("NISSAN");
        auto.setModelo("Nissan Opala");
        auto.setAnoFabricacao(2021);
        auto.setAnoModelo(2021);
        auto.setObservacoes("Novo modelo da Nissan, que trás melhorias significativas para veículos industriais.");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(auto);
        tx.commit();

        em.close();
    }

    public static void buscar() {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery("select a from Automovel a", Automovel.class);
        List<Automovel> autos = q.getResultList();
        for (Automovel a : autos) {
            System.out.println(a.getMarca());
            System.out.println(a.getAnoFabricacao());
            System.out.println(a.getAnoModelo());
        }
        em.close();
    }

    public static void excluir() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Automovel auto = em.getReference(Automovel.class, (long) 1);
        tx.begin();
        em.remove(auto);
        tx.commit();
    }
}
