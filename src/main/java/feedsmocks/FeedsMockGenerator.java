package feedsmocks;

import objectmapper.JSONObjectMapper;

import java.io.InputStream;

public class FeedsMockGenerator {

    public static void main(String[] args) throws Exception {
//        InputStream is = feedsmocks.FeedsMockGenerator.class.getClassLoader().getResourceAsStream("sampleMinPost.json");
//        FeedsPostWidget feedsPostWidget1 = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(is, FeedsPostWidget.class);
//        System.out.println(feedsPostWidget1);

        InputStream is = FeedsMockGenerator.class.getClassLoader().getResourceAsStream("pageresponse.json");
        feedsmocks.SamplePageResponse samplePageResponse = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(is, feedsmocks.SamplePageResponse.class);

        new FeedPostWidgetMockGenerator().printWidget();
    }
}
