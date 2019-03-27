import feedsmocks.SamplePageResponse;
import objectmapper.JSONObjectMapper;

import java.io.InputStream;

public class Boot {

    public static void main(String[] args) throws Exception {
        InputStream in = Boot.class.getClassLoader().getResourceAsStream("pageresponse.json");
        SamplePageResponse m = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(in, SamplePageResponse.class);
        System.out.println("Done");
    }
}
