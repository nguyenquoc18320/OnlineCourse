/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 *
 * @author A556U
 */
@Entity
public class Chap implements Serializable  {
//    @ManyToOne
//    private Course course;
    
    @Id
    private int CourseId;
    @Id
    private int Chapid ;
    private String Name;

     public Chap() {
    }

    public Chap(int CourseId, int Chapid, String Name) {
        this.CourseId = CourseId;
        this.Chapid = Chapid;
        this.Name = Name;
    }
     
     
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

   

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public int getChapid() {
        return Chapid;
    }

    public void setChapid(int Chapid) {
        this.Chapid = Chapid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
