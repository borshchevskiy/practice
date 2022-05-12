package my.home.hibernate_test_relation.one_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE departments (
    id SERIAL NOT NULL PRIMARY KEY ,
    department_name VARCHAR(15),
    max_salary INT,
    min_salary INT
);

CREATE TABLE employees (
    id SERIAL NOT NULL PRIMARY KEY ,
    first_name VARCHAR(15),
    surname VARCHAR(25),
    salary INT,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);


 */

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE},
            mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployee(Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
        employee.setDepartment(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
