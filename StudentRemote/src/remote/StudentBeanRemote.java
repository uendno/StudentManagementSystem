/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dtos.StudentDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author tranvietthang
 */
@Remote
public interface StudentBeanRemote {
    public void createStudent(StudentDTO studentDTO);
    public void deleteStudent(int id);
    public void updateStudent(StudentDTO studentDTO);
    public StudentDTO getStudent(int id);
    public List<StudentDTO> getStudentList();
    public String getMessage();
}
