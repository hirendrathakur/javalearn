package feedsmocks;

import com.flipkart.rome.datatypes.response.common.EmptyPageWidgetData;
import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.AnnouncementV2Value;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichButtonValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.EMPTY_PAGE_WIDGET;

public class EmptyWidgetDataMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return EMPTY_PAGE_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        EmptyPageWidgetData emptyPageWidgetData = new EmptyPageWidgetData();
        AnnouncementV2Value announcementV2Value = new AnnouncementV2Value();
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("That's all folks");

        RichTextValue subTitle = new RichTextValue();
        subTitle.setText("Check back tomorrow for updates");

        announcementV2Value.setTitle(new RenderableComponent<>(null, richTextValue));
        announcementV2Value.setSubTitle(new RenderableComponent<>(null, subTitle));
        announcementV2Value.setImage(getImageValue());
        RichButtonValue richButtonValue = new RichButtonValue();
        richButtonValue.setTitle("Go to top");
        richButtonValue.setButtonColor("blue");
        announcementV2Value.setButton(new RenderableComponent<>(null, richButtonValue));
        emptyPageWidgetData.setEmptyResponse(new RenderableComponent<>(null, announcementV2Value));
        printAndVerifyWidgetData(emptyPageWidgetData, EmptyPageWidgetData.class);
        return emptyPageWidgetData;
    }
}
