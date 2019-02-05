package powermockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticResource.class})
public class TestServiceTest {

//    @Spy
//    private TestService testServiceSpy;

    private TestService testService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setTestService() throws Exception {
        mockStatic(StaticResource.class);
        testService = spy(new TestService());
        when(testService.someFunctionToSpy()).thenReturn(2);
        testService.entryFunction("hirendra");
        Mockito.verify(testService, Mockito.times(1)).entryFunction("hirendra");
        Mockito.verify(testService, Mockito.times(1)).someFunctionToSpy();

        verifyStatic(Mockito.times(1));
        StaticResource.getValue();
        System.out.println("Done");
    }
}
