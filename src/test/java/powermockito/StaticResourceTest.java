package powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticResource.class)
public class StaticResourceTest {

    @Test
    public void verifyCheckValue() throws Exception {
        StaticResource staticResource = PowerMockito.spy(new StaticResource());
        PowerMockito.spy(StaticResource.class);
        PowerMockito.doReturn(1).when(StaticResource.class,"getValue");
        staticResource.upgradeAllCustomers();

        //this should be called separately for separate static functions
        //if we are testing 3 function calls then have to call verifyStatic() 3 times
        PowerMockito.verifyStatic();
        StaticResource.getValue();
        System.out.println("done");
    }
}
