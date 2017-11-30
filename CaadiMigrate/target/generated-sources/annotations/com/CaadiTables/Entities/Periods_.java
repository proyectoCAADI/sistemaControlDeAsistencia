package com.CaadiTables.Entities;

import com.CaadiTables.Entities.Visit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-30T04:06:31")
@StaticMetamodel(Periods.class)
public class Periods_ { 

    public static volatile CollectionAttribute<Periods, Visit> visitCollection;
    public static volatile SingularAttribute<Periods, Date> start;
    public static volatile SingularAttribute<Periods, String> description;
    public static volatile SingularAttribute<Periods, Date> end;
    public static volatile SingularAttribute<Periods, Integer> id;

}