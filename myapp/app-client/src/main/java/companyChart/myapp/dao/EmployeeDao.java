package companyChart.myapp.dao;

import companyChart.myapp.vo.Employee;

import java.util.List;

public interface EmployeeDao {

    void add(Employee employee);

    int delete(int no);

    List<Employee> findAll();

    Employee findBy(int no);

    int update(Employee employee);
}
