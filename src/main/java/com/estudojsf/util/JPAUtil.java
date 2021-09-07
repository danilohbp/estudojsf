
package com.estudojsf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danilohbp
 */
public class JPAUtil {
    
//    private JPAUtil(){}
    
    // Objeto responsável por criar a conexão com BD
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    
    // Objeto que representa a conexão com a unidade de persistencia
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
