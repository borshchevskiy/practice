package my.home.hibernate_test_relation.one_to_one.entity;

import javax.persistence.*;

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

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Detail employeeDetail;

    public Employee() {
    }

    public Employee(String first_name, String surname, String department, int salary) {
        this.firstName = first_name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(Detail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
