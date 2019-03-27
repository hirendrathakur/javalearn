package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.feeds.media.FeedsMediaValue;
import com.flipkart.rome.datatypes.response.feeds.post.FeedsMediaContent;
import com.flipkart.rome.datatypes.response.feeds.post.FeedsPostDetailValue;
import com.flipkart.rome.datatypes.response.feeds.post.FeedsPostValue;
import com.flipkart.rome.datatypes.response.feeds.post.FormattedTextDetail;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsPersonaProfile;
import com.flipkart.rome.datatypes.response.feeds.widgets.FeedsPostWidget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;
import objectmapper.JSONObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.feeds.post.enums.FeedsPostDetailType.FORMATTED_TEXT;
import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.FEEDS_POST;

public class FeedPostWidgetMockGenerator extends BaseMock {

    @Override
    String getSharedNameSpaceKey() {
        return "post_123";
    }

    @Override
    WidgetTypeV4 getWidgetType() {
        return FEEDS_POST;
    }

    @Override
    protected String getPostId() {
        return "post_123";
    }

    @Override
    protected String getPersonaId() {
        return "persona_123";
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        RenderableComponent<FeedsPersonaProfile> profileRenderableComponent = getPostCreatorRC();
        FeedsMediaValue feedsMediaValue = getFeedsImage();
        FeedsMediaContent feedsMediaContent = new FeedsMediaContent();
        feedsMediaContent.setContent(feedsMediaValue);
        RenderableComponent<FeedsPostValue> feedsPostContentRenderableComponent = new RenderableComponent<>(null, getImageMediaContent());
        FeedsPostWidget feedsPostWidget = new FeedsPostWidget(profileRenderableComponent, feedsPostContentRenderableComponent, getLikeToggleAction(), getSaveAction(), getShareAction());
        feedsPostWidget.setMenu(getFeedsPostMenuRC());
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("Check out the all new air collection");
        richTextValue.setTextColor("color");
        FormattedTextDetail formattedText = new FormattedTextDetail();
        formattedText.setValue(Arrays.asList(new RenderableComponent<>(null, richTextValue), new RenderableComponent<>(null, richTextValue)));
        FeedsPostDetailValue feedsPostDetailValue = new FeedsPostDetailValue(FORMATTED_TEXT, formattedText);
        RenderableComponent<FeedsPostDetailValue> FeedsPostDetailRenderableComponent = new RenderableComponent<>(null, feedsPostDetailValue);
        feedsPostWidget.setDetails(Collections.singletonList(FeedsPostDetailRenderableComponent));
        printAndVerifyWidgetData(feedsPostWidget, FeedsPostWidget.class);
        return feedsPostWidget;
    }
}
