package my.home.hibernate_test_crud;

import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3GetAll {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            // Get all employees
//            List<Employee> employees = session.createQuery("from Employee")
//                            .getResultList();


            //Get employee by name
            List<Employee> employees = session.createQuery("from Employee where firstName = 'Ivan' AND salary > 500")
                            .getResultList();


            for (Employee employee: employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();



        } finally {
            factory.close();
        }
    }
}
