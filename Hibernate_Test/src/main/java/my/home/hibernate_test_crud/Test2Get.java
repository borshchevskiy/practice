package my.home.hibernate_test_crud;

import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try {

            //Save object to db

            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Ivan", "Ivanov", "HR", 800);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            //----------------------------------------------
            //Get object by id

            int id = employee.getId();

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee myEmployee = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(myEmployee);

        } finally {
            factory.close();
        }
    }
}
