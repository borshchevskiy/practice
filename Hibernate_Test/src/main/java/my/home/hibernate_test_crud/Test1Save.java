package my.home.hibernate_test_crud;

import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*

CREATE TABLE employees (
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR(15),
    surname VARCHAR(25),
    department VARCHAR(20),
    salary INTEGER
);

 */

public class Test1Save {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //Save object to db

        try {
            Session session = factory.getCurrentSession();

            Employee employee1 = new Employee("John", "Doe", "IT", 1000);
            Employee employee2 = new Employee("Josh", "Woe", "IT", 2000);

            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
