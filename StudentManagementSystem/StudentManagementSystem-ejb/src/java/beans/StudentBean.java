/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import boundary.StudentFacade;
import dtos.StudentDTO;
import entities.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import remote.StudentBeanRemote;
import javax.ejb.Stateless;

/**
 *
 * @author tranvietthang
 */
@Stateless(mappedName = "ejb/StudentBeanRemote")
public class StudentBean implements StudentBeanRemote {

    @EJB
    private StudentFacade studentFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void createStudent(StudentDTO studentDTO) {
        Student student = new Student(
                0,
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getFaculty(),
                studentDTO.getDateOfBirth(),
                studentDTO.getDescription());
        studentFacade.create(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = new Student();
        student.setId(id);
        studentFacade.remove(student);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student student = new Student(
                0,
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getFaculty(),
                studentDTO.getDateOfBirth(),
                studentDTO.getDescription());
        studentFacade.edit(student);
    }

    @Override
    public StudentDTO getStudent(int id) {
        Student student = studentFacade.find(id);
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getFaculty(),
                student.getDateOfBirth(),
                student.getDescription()
        );
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getStudentList() {
        List<Student> students = studentFacade.findAll();
        List<StudentDTO> studentDTOs = new ArrayList();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getFaculty(),
                    student.getDateOfBirth(),
                    student.getDescription()
            );
            studentDTOs.add(studentDTO);
        }

        return studentDTOs;
    }

    @Override
    public String getMessage() {
        return "Hello from EJB";
    }
    
    
}
