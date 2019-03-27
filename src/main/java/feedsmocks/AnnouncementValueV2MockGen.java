package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.AnnouncementV2Value;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.WidgetSharedData;
import com.flipkart.rome.datatypes.response.page.v4.AnnouncementV2WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;

import java.util.HashMap;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.ANNOUNCEMENT_V2;

public class AnnouncementValueV2MockGen extends BaseMock {
    @Override
    String getSharedNameSpaceKey() {
        return null;
    }

    @Override
    WidgetTypeV4 getWidgetType() {
        return ANNOUNCEMENT_V2;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        AnnouncementV2WidgetData announcementV2WidgetData = new AnnouncementV2WidgetData();
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("INTRODUCING FLIPKART FEEDS");
        AnnouncementV2Value announcementV2Value = new AnnouncementV2Value();
        announcementV2Value.setTitle(new RenderableComponent<>(null, richTextValue));
        announcementV2WidgetData.setData(new RenderableComponent<>(null, announcementV2Value));
        printAndVerifyWidgetData(announcementV2WidgetData, AnnouncementV2WidgetData.class);
        return announcementV2WidgetData;
    }
}
