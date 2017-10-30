
package com.PerfilBase;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

import com.CaadiTables.JSFs.StudentsController;
import com.CaadiTables.JSFs.VisitController;
import com.CaadiTables.JSFs.GroupsController;
import com.CaadiTables.JSFs.TeachersController;

/**
 *
 * @author Iron-kike
 */
@Named(value = "perfilBase")
@Dependent
public class PerfilBase {
    
    private StudentsController Students;
    private VisitController Visits;
    private GroupsController Groups;
    private TeachersController Teachers;
    
    public PerfilBase() {}
    
    public PerfilBase(StudentsController Student, VisitController Visit, GroupsController Group, TeachersController Teacher) {
        Students = Student;
        Visits = Visit;
        Groups = Group;
        Teachers = Teacher;
    }
    
    public void setStudents(StudentsController Student) {
        Students = Student;
    }
    
    public StudentsController getStudents() {
        return Students;
    }
    
    public void setVisits(VisitController Visit) {
        Visits = Visit;
    }
    
    public VisitController getVisits() {
        return Visits;
    }
    
    public void setGroups(GroupsController Group) {
        Groups = Group;
    }
    
    public GroupsController getGroups() {
        return Groups;
    }
    
    public void setTeachers(TeachersController Teacher) {
        Teachers = Teacher;
    }
    
    public TeachersController getTeachers() {
        return Teachers;
    }
}
