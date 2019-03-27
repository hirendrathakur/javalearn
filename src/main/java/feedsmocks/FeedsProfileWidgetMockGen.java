package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsProfileCard;
import com.flipkart.rome.datatypes.response.feeds.widgets.FeedsProfileWidget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.Collections;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.FEEDS_PROFILE_WIDGET;

public class FeedsProfileWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return FEEDS_PROFILE_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        FeedsProfileWidget FeedsProfileWidget = new FeedsProfileWidget();
        FeedsProfileCard feedsProfileCard = getFeedsPersonaProfileCard();
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("Description of the persona");
        FeedsProfileWidget.setCoverPhoto(getImageValue());
        FeedsProfileWidget.setDescription(Collections.singletonList(new RenderableComponent<>(null, richTextValue)));
        FeedsProfileWidget.setProfile(feedsProfileCard);
        printAndVerifyWidgetData(FeedsProfileWidget, FeedsProfileWidget.class);
        return FeedsProfileWidget;
    }
}
