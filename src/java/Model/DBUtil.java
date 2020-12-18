/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author A556U
 */
public class DBUtil {
     private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Final_projectPU");
    
    public static EntityManagerFactory getEmFactory()
    {
        return emf;
    }
    
}
