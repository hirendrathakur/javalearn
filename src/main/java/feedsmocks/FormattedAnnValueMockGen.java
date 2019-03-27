package feedsmocks;

import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.FormattedAnnouncementValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.FormattedTextValue;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;
import com.flipkart.rome.datatypes.response.page.v4.widgetData.FormattedAnnouncementWidgetData;

import java.util.Arrays;
import java.util.Collections;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.FORMATTED_ANNOUNCEMENT;

public class FormattedAnnValueMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return FORMATTED_ANNOUNCEMENT;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        FormattedAnnouncementWidgetData formattedAnnouncementWidgetData = new FormattedAnnouncementWidgetData();
        FormattedAnnouncementValue formattedAnnouncementValue = new FormattedAnnouncementValue();

        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("Continue telling us your interests.");
        FormattedTextValue formattedTextValue = new FormattedTextValue();
        formattedTextValue.setFormattedValue(new RenderableComponent<>(null, richTextValue));
        formattedAnnouncementValue.setTitle(Collections.singletonList(formattedTextValue));

        RichTextValue subTitle = new RichTextValue();
        subTitle.setText("40% complete");
        FormattedTextValue formattedTextValue1 = new FormattedTextValue();
        formattedTextValue1.setFormattedValue(new RenderableComponent<>(null, subTitle));
        formattedAnnouncementValue.setSubTitle(Collections.singletonList(formattedTextValue1));
        formattedAnnouncementValue.setBgImage(getImageValue());
        formattedAnnouncementValue.setIconList(Arrays.asList(new RenderableComponent<>(null, getImageValue()), new RenderableComponent<>(null, getImageValue())));
        formattedAnnouncementWidgetData.setValue(formattedAnnouncementValue);
        printAndVerifyWidgetData(formattedAnnouncementWidgetData, FormattedAnnouncementWidgetData.class);
        return formattedAnnouncementWidgetData;
    }
}
