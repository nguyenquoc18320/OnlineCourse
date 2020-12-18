/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author A556U
 */
public class ChapDB {
    public static boolean insertChap(Chap chap)
    {
        boolean result;
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = entityManager.getTransaction();
        tran.begin();
        
        try
        {
            entityManager.persist(chap);
            tran.commit();
            result= true;
        }
        catch(Exception ex)
        {
            result= false;
            tran.rollback();
        }
        finally
        {
            entityManager.close();
        }       
        return result;
    }
    
    public static boolean updateChap(Chap chap)
    {
        boolean result;
        EntityManager entityManager= DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = entityManager.getTransaction();
        tran.begin();
        
        try
        {
            entityManager.merge(chap);
            tran.commit();
            result = true;
        }
        catch(Exception ex)
        {
            tran.rollback();
            result=false;
        }
        finally
        {
            entityManager.close();
        }
        return result;
    }
    
    public static int getMaxChapOfTheCourse(int courseid)
    {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String queryS = "Select Max(ChapId) from Chap where courseid = "+ courseid;
        
        try {
            int max = Integer.parseInt(entityManager.createNativeQuery(queryS).getSingleResult().toString());
            return max;
        } catch (Exception e) {
            return 0;
        } finally {
            entityManager.close();
        }
    }
    
    //check whether the chap exists
    public static boolean chapExists (int courseid, int chapid)
    {
        Chap chap = getChapByPrimaryKey(courseid, chapid);
        return chap!=null;              
    }
    
    //get Chap defined by primay key
    public static Chap getChapByPrimaryKey(int courseid, int chapid)
    {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String queryS = "Select c from Chap c where c.CourseId = :courseid and c.ChapId = :chapid";
        
        TypedQuery<Chap> query = entityManager.createQuery(queryS, Chap.class);
        query.setParameter("courseid", courseid);
        query.setParameter("chapid", chapid);
        
        Chap chap;
        try
        {
            chap = query.getSingleResult();         
        }
        catch(Exception ex)
        {
            chap= null;
        }
        finally
        {
            entityManager.close();
        }
        return chap;
    }
}
