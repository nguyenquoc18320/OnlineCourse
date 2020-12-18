/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author A556U
 */
public class CourseDB {

    public static boolean insertCourse(Course course) {
        boolean result = true;
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = entityManager.getTransaction();
        tran.begin();

        try {
            entityManager.persist(course);
            tran.commit();
        } catch (Exception e) {
            System.out.println(e);
            tran.rollback();
            result = false;
        } finally {
            entityManager.close();
        }
        return result;
    }

     public static boolean updateCourse(Course course) {
        boolean result = true;
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = entityManager.getTransaction();
        tran.begin();

        try {
            entityManager.merge(course);
            tran.commit();
        } catch (Exception e) {
            System.out.println(e);
            tran.rollback();
            result = false;
        } finally {
            entityManager.close();
        }
        return result;
    }
     
    public static int getMaxCourseID() {
       int max=0;
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String queryS = "SELECT max(courseid) from Course";

        try {
             max = Integer.parseInt(entityManager.createNativeQuery(queryS).getSingleResult().toString());

        } catch (Exception e) {
            max=0;
        } finally {
            entityManager.close();
        }
        return max;
    }

    public static Course getCourseById(int courseid) {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String queryS = "SELECT c from Course c where c.courseid = :courseid";
        TypedQuery<Course> query = entityManager.createQuery(queryS, Course.class);
        query.setParameter("courseid", courseid);

         Course course =null;
        try {
            course= query.getSingleResult();
        } catch (Exception ex) {
            
        }
        finally
        {
            entityManager.close();
        }
        return course;
    }
    
    public static boolean courseExists(int courseid)
    {
        Course u = getCourseById(courseid);
        return u!=null;
    }
}
