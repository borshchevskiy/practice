package my.home.hibernate_test_crud;

import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            //Delete object

            Session session = factory.getCurrentSession();

            session.beginTransaction();

              //Delete 1 object
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);

            session.createQuery("delete Employee where firstName = 'John'").executeUpdate();


            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
