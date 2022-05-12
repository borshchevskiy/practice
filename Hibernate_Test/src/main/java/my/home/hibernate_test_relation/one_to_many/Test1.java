package my.home.hibernate_test_relation.one_to_many;


import my.home.hibernate_test_relation.one_to_many.entity.Department;
import my.home.hibernate_test_relation.one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            /*
             * Add employees and department
             *
            Department ITDepartment = new Department("IT", 1200, 300);
            Employee employee1 = new Employee("Ivan", "Ivanov", 1000);
            Employee employee2 = new Employee("Anton", "Antonov", 1200);
            ITDepartment.addEmployee(employee1);
            ITDepartment.addEmployee(employee2);
            session.save(ITDepartment);
             */
            session.beginTransaction();

            Department department = session.get(Department.class, 1);

            System.out.println(department);
            System.out.println(department.getEmployees());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
