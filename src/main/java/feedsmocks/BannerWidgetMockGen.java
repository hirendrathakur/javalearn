package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;
import com.flipkart.rome.datatypes.response.page.v4.widgetData.BannerWidgetData;

import java.util.Collections;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.BUTTON_TAGS_WIDGET;

public class BannerWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return BUTTON_TAGS_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        BannerWidgetData bannerWidgetData = new BannerWidgetData();
        bannerWidgetData.setRenderableComponents(Collections.singletonList(new RenderableComponent<>(null, getImageValue())));
        printAndVerifyWidgetData(bannerWidgetData, BannerWidgetData.class);
        return bannerWidgetData;
    }
}
