package com.CaadiTables.Entities;

import com.CaadiTables.Entities.Periods;
import com.CaadiTables.Entities.Students;
import com.CaadiTables.Entities.Teachers;
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
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> learningUnit;
    public static volatile SingularAttribute<Groups, String> identifier;
    public static volatile SingularAttribute<Groups, Periods> periodId;
    public static volatile SingularAttribute<Groups, String> level;
    public static volatile CollectionAttribute<Groups, Students> studentsCollection;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile SingularAttribute<Groups, Teachers> employeeNumber;

}