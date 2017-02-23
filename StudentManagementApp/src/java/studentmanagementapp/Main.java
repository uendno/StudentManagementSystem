/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementapp;

import dtos.StudentDTO;
import java.util.Date;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.StudentBeanRemote;

/**
 *
 * @author tranvietthang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Properties props = new Properties();
        try {
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            // glassfish default port value will be 3700,
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ctx = new InitialContext(props);

            StudentBeanRemote bean = (StudentBeanRemote) ctx.lookup("ejb/StudentBeanRemote");

            //System.out.print(bean.getMessage());

            // Create
            StudentDTO student = new StudentDTO(0, "test", "test", "test", new Date(), "test");
            bean.createStudent(student);

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
}
