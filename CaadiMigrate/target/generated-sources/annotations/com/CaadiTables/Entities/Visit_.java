package com.CaadiTables.Entities;

import com.CaadiTables.Entities.Periods;
import com.CaadiTables.Entities.Students;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-20T23:56:26")
@StaticMetamodel(Visit.class)
public class Visit_ { 

    public static volatile SingularAttribute<Visit, Periods> periodId;
    public static volatile SingularAttribute<Visit, String> skill;
    public static volatile SingularAttribute<Visit, Date> start;
    public static volatile SingularAttribute<Visit, Date> end;
    public static volatile SingularAttribute<Visit, Integer> id;
    public static volatile SingularAttribute<Visit, Students> nua;

}