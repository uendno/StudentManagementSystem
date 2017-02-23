/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import boundary.StudentFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import entities.Student;
import java.util.List;
/**
 *
 * @author tranvietthang
 */
@Named(value = "studentListView")
@Dependent
public class StudentListView {

    @EJB
    private StudentFacade studentFacade;

    /**
     * Creates a new instance of StudentListView
     */
    public StudentListView() {
    }
    
    public List<Student> getStudentList() {
        return studentFacade.findAll();
    }
}
