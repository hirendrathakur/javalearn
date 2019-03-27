package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichButtonValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.ToggleValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedDataKey;
import com.flipkart.rome.datatypes.response.feeds.widgets.FeedsOnboardingWidget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.Arrays;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.FEEDS_ONBOARDING_WIDGET;

public class FeedsOnboardingWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return FEEDS_ONBOARDING_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        FeedsOnboardingWidget feedsOnboardingWidget = new FeedsOnboardingWidget();
        RichButtonValue selectedButtonValue = new RichButtonValue();
        selectedButtonValue.setButtonColor("blue");
        RichButtonValue unselectedButtonValue = new RichButtonValue();
        selectedButtonValue.setButtonColor("white");
        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey("isAdded");
        ToggleValue<RichButtonValue> toggleValueRc = new ToggleValue<>(widgetSharedDataKey,
                new RenderableComponent<>(null, selectedButtonValue),
                new RenderableComponent<>(null, unselectedButtonValue));
        RenderableComponent<ToggleValue<RichButtonValue>> renderableComponent = new RenderableComponent<>(null, toggleValueRc);
        feedsOnboardingWidget.setContentList(Arrays.asList(renderableComponent, renderableComponent));

        RichButtonValue navButton = new RichButtonValue();
        navButton.setTitle("Take me to my feed");
        navButton.setButtonColor("orange");
        feedsOnboardingWidget.setNavigationButton(new RenderableComponent<>(null, navButton));
        printAndVerifyWidgetData(feedsOnboardingWidget, FeedsOnboardingWidget.class);
        return feedsOnboardingWidget;
    }
}
