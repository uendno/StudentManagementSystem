/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import boundary.StudentFacade;
import entities.Student;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author tranvietthang
 */
@Named(value = "studentDetailView")
@Dependent
public class StudentDetailView {

    private Student student;
    
    @EJB
    private StudentFacade studentFacade;

    /**
     * Creates a new instance of StudentDetailView
     */
    public StudentDetailView() {
    }
    
    public Student getStudent(int id) {
        if  (student != null) {
            return student;
        }
         
        return studentFacade.find(id);
    }
    
}
