package com.kissmepls.spring.rest.dao;

import com.kissmepls.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Employee> getAllEmployees()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee order by id", Employee.class)
                .getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        Session session = sessionFactory.getCurrentSession();

        session.merge(employee);
    }

    @Override
    public Employee getEmployee(int id)
    {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id)
    {
        Session session = sessionFactory.getCurrentSession();

//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//
//        query.executeUpdate();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
    }
}
