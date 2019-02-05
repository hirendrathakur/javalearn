package powermockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerDao daoMock;

    @Mock
    CustomerService.test test;


    @InjectMocks
    private CustomerService service;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {

        when(daoMock.save(any(Customer.class))).thenReturn(true);
        when(daoMock.exists(anyLong())).thenReturn(false);

        Customer customer=new Customer();
        assertThat(service.addCustomer(customer), is(true));

        //verify that the save method has been invoked
        //verify(daoMock, never()).save(any(Customer.class));
        //the above is similar to :  verify(daoMock, times(1)).save(any(Customer.class));

        //verify that the exists method is invoked one time
        //verify(daoMock, times(1)).exists(any());

        //verify that the delete method has never been  invoked

        //verify(daoMock, never()).delete(any(Customer.class));
    }

}
