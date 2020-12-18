/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
/**
 *
 * @author A556U
 */
@Entity
public class Course {
    
    @Id
    private int courseid;
    private String name;
    private String objective;
    private int userid;
    @Temporal (TemporalType.TIMESTAMP)
    private Date modifiedDate;
    private boolean approved;

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
    private String document;

    public Course()
    {
        
    }

    public Course(int courseid, String name, String objective, int userid, Date modifiedDate,  String document) {
        this.courseid = courseid;
        this.name = name;
        this.objective = objective;
        this.userid = userid;
        this.modifiedDate = modifiedDate;
        this.objective = objective;
        this.document = document;
    }
       
    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    
     
}
