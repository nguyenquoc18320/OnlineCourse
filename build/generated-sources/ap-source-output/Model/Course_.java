package Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-18T08:39:27")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Boolean> approved;
    public static volatile SingularAttribute<Course, String> document;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Date> modifiedDate;
    public static volatile SingularAttribute<Course, Integer> courseid;
    public static volatile SingularAttribute<Course, Integer> userid;
    public static volatile SingularAttribute<Course, String> objective;

}