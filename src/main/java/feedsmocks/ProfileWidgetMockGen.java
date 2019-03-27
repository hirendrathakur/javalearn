package feedsmocks;

import com.flipkart.rome.datatypes.response.common.Profile;
import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.RichTextValue;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;
import com.flipkart.rome.datatypes.response.page.v4.widgetData.ProfileWidgetData;

import java.util.Arrays;

import static com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4.PROFILE_WIDGET;

public class ProfileWidgetMockGen extends BaseMock {
    @Override
    WidgetTypeV4 getWidgetType() {
        return PROFILE_WIDGET;
    }

    @Override
    WidgetData getWidgetData() throws Exception {
        ProfileWidgetData profileWidget = new ProfileWidgetData();
        RichTextValue richTextValue = new RichTextValue();
        richTextValue.setText("Title");
        RichTextValue subtitle = new RichTextValue();
        subtitle.setText("subtitle");
        Profile profile = new Profile(new RenderableComponent<>(null, richTextValue), new RenderableComponent<>(null, getImageValue()));
        profile.setSubTitle(Arrays.asList(new RenderableComponent<>(null, subtitle), new RenderableComponent<>(null, subtitle)));
        profileWidget.setProfileValue(profile);
        printAndVerifyWidgetData(profileWidget, ProfileWidgetData.class);
        return profileWidget;
    }
}
