package com.CaadiTables.Entities;

import com.CaadiTables.Entities.Visit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-19T01:31:11")
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-20T23:56:26")
>>>>>>> feature/menuAndTableStyle
=======
@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-21T23:39:42")
>>>>>>> b2dad42db2a6dc16b853312cb672e943caab1cfa
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, Date> birthday;
    public static volatile SingularAttribute<Students, String> secondLastName;
    public static volatile SingularAttribute<Students, String> firstLastName;
    public static volatile CollectionAttribute<Students, Visit> visitCollection;
    public static volatile SingularAttribute<Students, String> gender;
    public static volatile SingularAttribute<Students, String> name;
    public static volatile SingularAttribute<Students, String> nua;
    public static volatile SingularAttribute<Students, String> program;
    public static volatile SingularAttribute<Students, String> email;

}