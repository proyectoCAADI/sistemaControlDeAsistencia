package com.CaadiTables.Entities;

import com.CaadiTables.Entities.Groups;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-20T23:56:26")
@StaticMetamodel(Teachers.class)
public class Teachers_ { 

    public static volatile SingularAttribute<Teachers, String> secondLastName;
    public static volatile SingularAttribute<Teachers, String> firstLastName;
    public static volatile SingularAttribute<Teachers, String> gender;
    public static volatile SingularAttribute<Teachers, String> name;
    public static volatile CollectionAttribute<Teachers, Groups> groupsCollection;
    public static volatile SingularAttribute<Teachers, String> email;
    public static volatile SingularAttribute<Teachers, String> employeeNumber;

}