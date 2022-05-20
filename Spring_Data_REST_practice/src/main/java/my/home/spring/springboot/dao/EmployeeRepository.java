package my.home.spring.springboot.dao;

import my.home.spring.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

}
