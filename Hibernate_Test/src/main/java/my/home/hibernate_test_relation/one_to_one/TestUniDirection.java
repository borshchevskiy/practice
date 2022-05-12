package my.home.hibernate_test_relation.one_to_one;

import my.home.hibernate_test_relation.one_to_one.entity.Detail;
import my.home.hibernate_test_relation.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
CREATE TABLE details (
    id SERIAL NOT NULL PRIMARY KEY ,
    city VARCHAR(15),
    phone_number VARCHAR(25),
    email VARCHAR(30)
);

CREATE TABLE employees (
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR(15),
    surname VARCHAR(25),
    department VARCHAR(20),
    salary INTEGER,
    details_id INTEGER,
    FOREIGN KEY (details_id) REFERENCES details(id)
);


 */

public class TestUniDirection {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = new Employee("Oleg", "Olegov", "IT", 2000);
//            Detail detail = new Detail("Voronezh", "123456", "Oleg@gmail.com");
//            Employee employee = new Employee("Artem", "Artemov", "HR", 1000);
//            Detail detail = new Detail("Vorkuta", "654321", "Artem@gmail.com");

//            employee.setEmployeeDetail(detail);
//
//            session.save(employee);

            session.getTransaction().commit();

            //-----------------------------------------------------------------------

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmployeeDetail());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
