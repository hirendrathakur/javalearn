package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichButtonValue;
import com.flipkart.rome.datatypes.response.feeds.widgets.ButtonTagsWidget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.Collections;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.BUTTON_TAGS_WIDGET;

public class FeedsTagsWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return BUTTON_TAGS_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        ButtonTagsWidget tagsWidget = new ButtonTagsWidget();
        RichButtonValue richButtonValue = new RichButtonValue();
        richButtonValue.setBorderColor("borderColor");
        richButtonValue.setButtonColor("buttonColor");
        richButtonValue.setButtonTextColor("Button Text");
        tagsWidget.setTags(Collections.singletonList(new RenderableComponent<>(null, richButtonValue)));
        printAndVerifyWidgetData(tagsWidget, ButtonTagsWidget.class);
        return tagsWidget;
    }
}
