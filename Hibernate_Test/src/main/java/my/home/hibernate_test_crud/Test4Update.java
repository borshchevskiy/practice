package my.home.hibernate_test_crud;

import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4Update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            //Update object in db

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(1000);

            session.createQuery("update Employee set salary = 2000 where firstName = 'John'")
                            .executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
