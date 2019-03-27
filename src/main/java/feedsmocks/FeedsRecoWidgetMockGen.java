package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsProfileCard;
import com.flipkart.rome.datatypes.response.feeds.widgets.FeedsRecommendationWidget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.Collections;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.FEEDS_RECOMMENDATION_WIDGET;

public class FeedsRecoWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return FEEDS_RECOMMENDATION_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        FeedsRecommendationWidget feedsRecommendationWidget = new FeedsRecommendationWidget();
        FeedsProfileCard profileCard = getFeedsPersonaProfileCard();
        feedsRecommendationWidget.setRecommendations(Collections.singletonList(new RenderableComponent<>(null, profileCard)));
        printAndVerifyWidgetData(feedsRecommendationWidget, FeedsRecommendationWidget.class);
        return feedsRecommendationWidget;
    }

}
