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
    private int CourseId;
    private String Name;
    private String Objective;
    private int UserId;
    @Temporal (TemporalType.TIMESTAMP)
    private Date ModifiedDate;
    private String Document;

   
    public Course()
    {
        
    }

    public Course(int courseid, String name, String objective, int userid, Date modifiedDate,  String document) {
        this.CourseId = courseid;
        this.Name = name;
        this.Objective = objective;
        this.UserId = userid;
        this.ModifiedDate = modifiedDate;
        this.Document = document;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getObjective() {
        return Objective;
    }

    public void setObjective(String Objective) {
        this.Objective = Objective;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String Document) {
        this.Document = Document;
    }
      
    
    
     
}
