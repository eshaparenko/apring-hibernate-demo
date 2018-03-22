package com.app.springdemo.dao;

import com.app.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
    //Inject session factory
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    @Transactional
    public List<Customer> getCustomers()
    {
        //get current session
         Session currentSession = sessionFactory.getCurrentSession();
        //create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        //execute query
        List<Customer> customers = theQuery.getResultList();
        //return the result

        return customers;
    }
}
