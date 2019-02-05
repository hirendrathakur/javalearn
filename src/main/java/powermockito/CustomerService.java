package powermockito;

import javax.inject.Inject;

public class CustomerService {


    @Inject
    private CustomerDao customerDao;


    private test test;

    public class test {
        void get() {}
    }

    public boolean addCustomer(Customer customer){
        test.get();
        if(customerDao.exists(customer.getPhone())){
            return true;
        }

        return customerDao.save(customer);
    }
    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}
