package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> search(String name_search, String address_search) {
        return customerRepository.search(name_search, address_search);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
