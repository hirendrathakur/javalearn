package feedsmocks;

import com.flipkart.rome.datatypes.request.feeds.enums.InteractionType;
import com.flipkart.rome.datatypes.response.common.Action;
import com.flipkart.rome.datatypes.response.common.leaf.RenderableComponent;
import com.flipkart.rome.datatypes.response.common.leaf.value.*;
import com.flipkart.rome.datatypes.response.enums.LoginType;
import com.flipkart.rome.datatypes.response.feeds.media.*;
import com.flipkart.rome.datatypes.response.feeds.post.*;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsInterestProfile;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsPersonaProfile;
import com.flipkart.rome.datatypes.response.feeds.profiles.FeedsProfileCard;
import com.flipkart.rome.datatypes.response.page.v4.Widget;
import com.flipkart.rome.datatypes.response.page.v4.WidgetData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetSlotData;
import com.flipkart.rome.datatypes.response.page.v4.WidgetTypeV4;
import objectmapper.JSONObjectMapper;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.flipkart.rome.datatypes.response.feeds.media.enums.FeedsMediaType.IMAGE;
import static com.flipkart.rome.datatypes.response.feeds.media.enums.FeedsMediaType.VIDEO;
import static com.flipkart.rome.datatypes.response.feeds.media.enums.StaticMediaSourceType.RUKMINI;
import static com.flipkart.rome.datatypes.response.feeds.media.enums.VideoSourceType.DASH;
import static com.flipkart.rome.datatypes.response.feeds.post.enums.ActionType.*;
import static com.flipkart.rome.datatypes.response.feeds.post.enums.FeedsPostContentType.MEDIA;
import static com.flipkart.rome.datatypes.response.feeds.post.enums.FeedsPostContentType.STORY;

abstract class BaseMock {

    private static final String saveIcon = "https://rukminim1.flixcart.com/www/{@width}/{@height}/promos/27/03/2019/fea8de1d-dc54-4b53-aed5-2547697f694b.png?q={@quality}";
    private static final String shareIcon = "https://rukminim1.flixcart.com/www/{@width}/{@height}/promos/27/03/2019/7fee2070-f833-434b-a8eb-ec76d6b3d25a.png?q={@quality}";
    private static final String likedIcon = "https://rukminim1.flixcart.com/www/{@width}/{@height}/promos/27/03/2019/8c5a6bc0-68d3-4ecc-b2bd-1e22b9be9fa6.png?q={@quality}";
    private static final String likeIcon = "https://rukminim1.flixcart.com/www/{@width}/{@height}/promos/27/03/2019/ad1c2175-a1f3-4de2-af72-8bf5c15cae73.png?q={@quality}";
    private static final String savedIcon = "https://rukminim1.flixcart.com/www/{@width}/{@height}/promos/27/03/2019/d1d8d109-3921-4f6f-90d9-70c8d01f4924.png?q={@quality}";

    private static final String feedsPersonaUrl = "/feeds/persona";
    private static final String feedsInteractionUrl = "/1/userfeeds/interaction";

    private static final String selectedColorCode = "#2873f1";
    private static final String unSelectedColorCode = "#878787";
    private static final String NAMESPACE = "feeds";

    private static Map<String, WidgetSharedData> widgetSharedDataMap = new HashMap<>();

    private static final String like = "like";
    private static final String save = "save";
    private static final String follow = "follow";

    String getSharedNameSpaceKey() {
        return null;
    }

    private static String getFormattedSharedKey(String key1, String key2) {
        return key1 + "_" + key2;
    }

    private static String getSelectedKey(String key) {
        return getFormattedValue(key, "Selected");
    }

    private static String getSelectedTextKey(String key) {
        return getFormattedValue(key, "SelectedText");
    }

    private static String getUnSelectedTextKey(String key) {
        return getFormattedValue(key, "UnSelected");
    }

    private static String getFormattedValue(String key1, String key2) {
        return key1 + key2;
    }

    public enum SharedKeyEnum {
        POST_LIKE_SELECTED(getSelectedKey(like)),
        POST_LIKE_SELECTED_TEXT(getSelectedTextKey(like)),
        POST_LIKE_UNSELECTED_TEXT(getUnSelectedTextKey(like)),
        POST_SAVE_SELECTED(getSelectedKey(save)),
        PERSONA_FOLLOW_SELECTED(getSelectedKey(follow)),
        PERSONA_FOLLOW_COUNT_TEXT(getSelectedTextKey(follow)),
        PERSONA_POST_COUNT_TEXT(getUnSelectedTextKey(follow));

        private String value;

        SharedKeyEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private String getSharedKey(SharedKeyEnum sharedKeyEnum) {
        WidgetSharedData widgetSharedData;
        String key;
        switch (sharedKeyEnum) {
            case POST_LIKE_SELECTED:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPostId(), "like");
                key = getPostIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case POST_LIKE_SELECTED_TEXT:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPostId(), "likeSelectedText");
                key = getPostIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case POST_LIKE_UNSELECTED_TEXT:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPostId(), "likeUnSelectedText");
                key = getPostIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case POST_SAVE_SELECTED:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPostId(), "saved");
                key = getPostIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case PERSONA_FOLLOW_SELECTED:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPersonaId(), "isFollowing");
                key = getPersonaIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case PERSONA_FOLLOW_COUNT_TEXT:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPersonaId(), "followCountString");
                key = getPersonaIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            case PERSONA_POST_COUNT_TEXT:
                widgetSharedData = new WidgetSharedData(NAMESPACE, getPersonaId(), "postCountString");
                key = getPersonaIdKey(widgetSharedData.getKey());
                widgetSharedDataMap.put(key, widgetSharedData);
                return key;
            default:
                return null;
        }
    }

    protected String getPostId() {
        return null;
    }

    protected String getPostIdKey(String key) {
        return getPostId() + "_" + key;
    }

    protected String getPersonaId() {
        return null;
    }

    private String getPersonaIdKey(String key) {
        return getPersonaId() + "_" + key;
    }

    abstract WidgetTypeV4 getWidgetType();

    private Widget getWidget() throws Exception {
        InputStream is = BaseMock.class.getClassLoader().getResourceAsStream("sampleWidget.json");
        Widget widget = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(is, Widget.class);
        widget.setData(getWidgetData());
        widget.setSharedData(getWidgetSharedDataMap());
        widget.setType(getWidgetType());
        return widget;
    }

    void printWidget() throws Exception {
        System.out.println(getString(getWidget()));
        printPageLevelSharedData();
        System.exit(0);
    }

    private void printPageLevelSharedData() throws Exception {
        Map<String, Map<String, Map<String, Object>>> nameSpaceToSharedValueMap = new HashMap<>();
        Map<String, Map<String, Object>> keyToSharedValueMap = new HashMap<>();
        for (Map.Entry<String, WidgetSharedData> entry : widgetSharedDataMap.entrySet()) {
            WidgetSharedData widgetSharedData = entry.getValue();
            Map<String, Object> sharedDataValue = keyToSharedValueMap.get(widgetSharedData.getId());
            if (sharedDataValue != null) {
                sharedDataValue.put(widgetSharedData.getKey(), null);
            } else {
                Map<String, Object> x = new HashMap<>();
                x.put(widgetSharedData.getKey(), null);
                keyToSharedValueMap.put(widgetSharedData.getId(), x);
            }
        }
        nameSpaceToSharedValueMap.put(NAMESPACE, keyToSharedValueMap);
        System.out.println(JSONObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(nameSpaceToSharedValueMap));

    }

    private Map<String, WidgetSharedData> getWidgetSharedDataMap() {
        return widgetSharedDataMap;
    }

    abstract WidgetData getWidgetData() throws Exception;

    WidgetSlotData widgetSlotData() throws Exception {
        InputStream is = BaseMock.class.getClassLoader().getResourceAsStream("sampleWidgetSlotData.json");
        WidgetSlotData widgetSlotData = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(is, WidgetSlotData.class);
        widgetSlotData.setWidget(getWidget());
        return widgetSlotData;
    }

    FeedsMediaValue getFeedsImage() {
        FeedsStaticMediaSource feedsStaticMediaSource = new FeedsStaticMediaSource(RUKMINI);
        feedsStaticMediaSource.setResolution(360);
        feedsStaticMediaSource.setUrl("http://rukmini1.flixcart.com/www/{@width}/{@height}/promos/27/08/2016/6ab38f02-18fc-4df6-a578-9a55057a3d23.png?q={@quality}");
        FeedsImage feedsImage = new FeedsImage();
        feedsImage.setDisplayDurationInSec(5);
        feedsImage.setAspectRatio(1.7);
        feedsImage.setSources(Collections.singletonList(feedsStaticMediaSource));
        feedsImage.setTheaterModeCallOut(getTheaterModeCalloutRC());
        return new FeedsMediaValue(IMAGE, feedsImage);
    }

    private RenderableComponent<RichTextValue> getTheaterModeCalloutRC() {
        RichTextValue theaterModeCallout = new RichTextValue();
        theaterModeCallout.setText("Swipe for details");
        return new RenderableComponent<>(null, theaterModeCallout);
    }

    void printAndVerifyWidgetData(WidgetData widgetData, Class<?> clazz) throws Exception {
        String widgetDataString = getString(widgetData);
        System.out.println(widgetDataString);
        //verifyDeserialisation(widgetDataString, clazz);
    }

    private String getString(Object obj) throws Exception {
        return JSONObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(obj);
    }

    void verifyDeserialisation(String payload, Class<?> clazz) throws Exception {
        JSONObjectMapper.INSTANCE.getObjectMapper().readValue(payload, clazz);
    }

    private FeedsMediaValue getFeedsVideo() {
        FeedsVideoSource FeedsVideoSource = new FeedsVideoSource();
        FeedsVideoSource.setSourceType(DASH);
        FeedsVideoSource.setUrl("someUrl");
        FeedsVideoSource.setResolution(1080);

        FeedsVideo feedsVideo = new FeedsVideo(1, true, true);
        feedsVideo.setSources(Collections.singletonList(FeedsVideoSource));
        feedsVideo.setGroupId("postId");
        feedsVideo.setAutoPlay(true);
        feedsVideo.setThumbnail(getImageValue());
        feedsVideo.setDurationInSec(10);
        feedsVideo.setAspectRatio(1.7);
        feedsVideo.setTheaterModeCallOut(getTheaterModeCalloutRC());
        return new FeedsMediaValue(VIDEO, feedsVideo);
    }

    protected FeedsPostValue getStoryContent() {
        FeedsStoryContent feedsStoryContent = new FeedsStoryContent();
        feedsStoryContent.setContent(Arrays.asList(getFeedsImage(), getFeedsVideo()));
        feedsStoryContent.setTheaterModeEnabled(true);
        return new FeedsPostValue(STORY, feedsStoryContent);
    }

    FeedsPostValue getImageMediaContent() {
        FeedsMediaContent feedsMediaContent = new FeedsMediaContent();
        feedsMediaContent.setContent(getFeedsImage());
        feedsMediaContent.setTheaterModeEnabled(true);
        return new FeedsPostValue(MEDIA, feedsMediaContent);
    }

    protected FeedsPostValue getVideoMediaContent() {
        FeedsMediaContent feedsMediaContent = new FeedsMediaContent();
        feedsMediaContent.setContent(getFeedsVideo());
        feedsMediaContent.setTheaterModeEnabled(true);
        return new FeedsPostValue(MEDIA, feedsMediaContent);
    }

    RenderableComponent<FeedsPostMenu> getFeedsPostMenuRC() {
        FeedsPostMenu FeedsPostMenu = new FeedsPostMenu();
        FeedsPostMenu.setOptions(Arrays.asList(getHideActionValue(), getReportActionValue(), getFollowActionValue()));
        return new RenderableComponent<>(null, FeedsPostMenu);
    }

    private RenderableComponent<ActionContentValue> getPostActionContentRC(InteractionType interactionType, RichTextValue richTextValue, ImageValue imageValue) {
        ActionContentValue postActionContentValue = new ActionContentValue(richTextValue);
        postActionContentValue.setIcon(imageValue);
        return new RenderableComponent<>(getAction(feedsInteractionUrl, interactionType), postActionContentValue);
    }

    private RenderableComponent<ActionContentValue> getPostActionContentRC(InteractionType interactionType, RichTextValue richTextValue) {
        ActionContentValue postActionContentValue = new ActionContentValue(richTextValue);
        return new RenderableComponent<>(getAction(feedsInteractionUrl, interactionType), postActionContentValue);
    }

    private FeedsActionValue getHideActionValue() {
        RichTextValue hide = new RichTextValue();
        hide.setText("Hide");

        ImageValue imageValue = getImageValue();
        FeedsStaticAction defaultAction = new FeedsStaticAction();
        defaultAction.setValue(getPostActionContentRC(InteractionType.HIDE, hide, imageValue));
        return new FeedsActionValue(HIDE, defaultAction);
    }

    ImageValue getImageValue() {
        ImageValue imageValue = new ImageValue();
        imageValue.setDynamicImageUrl("http://rukmini1.flixcart.com/www/{@width}/{@height}/promos/27/08/2016/6ab38f02-18fc-4df6-a578-9a55057a3d23.png?q={@quality}");
        return imageValue;
    }

    private ImageValue getImageValue(String url) {
        ImageValue imageValue = new ImageValue();
        imageValue.setDynamicImageUrl(url);
        return imageValue;
    }

    private ImageValue getSavedIconImageValue() {
        return getImageValue(savedIcon);
    }

    private ImageValue getSaveIconImageValue() {
        return getImageValue(saveIcon);
    }

    private ImageValue getLikedIconImageValue() {
        return getImageValue(likedIcon);
    }

    private ImageValue getLikeIconImageValue() {
        return getImageValue(likeIcon);
    }

    private ImageValue getShareIconImageValue() {
        return getImageValue(shareIcon);
    }

    private FeedsActionValue getReportActionValue() {
        RichTextValue report = new RichTextValue();
        report.setTitle("Report");
        report.setText("Report");

        ImageValue imageValue = getImageValue();

        FeedsStaticAction defaultAction = new FeedsStaticAction();
        defaultAction.setValue(getPostActionContentRC(InteractionType.REPORT, report, imageValue));
        return new FeedsActionValue(REPORT, defaultAction);
    }

    protected FeedsActionValue getLikeActionValue() {
        return new FeedsActionValue(LIKE, getLikeToggleAction());
    }

    FeedsToggleAction getLikeToggleAction() {
        RichTextValue like = new RichTextValue();
        WidgetSharedDataKey<String> widgetSharedDataKeyForLikeText = new WidgetSharedDataKey<>();
        widgetSharedDataKeyForLikeText.setSharedDataKey(getSharedKey(SharedKeyEnum.POST_LIKE_SELECTED_TEXT));
        like.setSharedText(widgetSharedDataKeyForLikeText);

        RichTextValue unLike = new RichTextValue();
        WidgetSharedDataKey<String> widgetSharedDataKeyForUnLikeText = new WidgetSharedDataKey<>();
        widgetSharedDataKeyForUnLikeText.setSharedDataKey(getSharedKey(SharedKeyEnum.POST_LIKE_UNSELECTED_TEXT));
        like.setSharedText(widgetSharedDataKeyForUnLikeText);

        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey(getSharedKey(SharedKeyEnum.POST_LIKE_SELECTED));

        ToggleValue<ActionContentValue> toggleValue = new ToggleValue<>(widgetSharedDataKey,
                getPostActionContentRC(InteractionType.LIKE, like, getLikedIconImageValue()),
                getPostActionContentRC(InteractionType.UNLIKE, unLike, getLikeIconImageValue()));
        FeedsToggleAction feedsToggleAction = new FeedsToggleAction();
        feedsToggleAction.setValue(toggleValue);
        return feedsToggleAction;
    }

    FeedsActionValue getShareActionValue() {
        return new FeedsActionValue(SHARE, getShareAction());
    }

    FeedsStaticAction getShareAction() {
        RichTextValue share = new RichTextValue();
        share.setText("Share");

        FeedsStaticAction defaultAction = new FeedsStaticAction();
        ActionContentValue postActionContentValue = new ActionContentValue(share);

        Action action = new Action();
        action.setScreenType("share");
        action.setType("SHARE");
        Map<String, Object> params = new HashMap<>();
        params.put("url", "\"http://dl.flipkart.com/dl/honor-9n-sapphire-blue-32-gb/p/itmf9pgsehv6nmss?pid=MOBF6NAR36DUGTAG&cmpid=product.share.pp");
        action.setParams(params);
        new RenderableComponent<>(action, postActionContentValue);
        return defaultAction;
    }

    protected FeedsActionValue getSaveActionValue() {
        return new FeedsActionValue(SAVE, getSaveAction());
    }

    FeedsToggleAction getSaveAction() {
        RichTextValue save = new RichTextValue();
        save.setText("Save");
        RichTextValue saved = new RichTextValue();
        saved.setText("Saved");

        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey(getSharedKey(SharedKeyEnum.POST_SAVE_SELECTED));


        ToggleValue<ActionContentValue> toggleValue = new ToggleValue<>(widgetSharedDataKey,
                getPostActionContentRC(InteractionType.SAVE, save, getSavedIconImageValue()),
                getPostActionContentRC(InteractionType.UNSAVE, saved, getSaveIconImageValue()));
        FeedsToggleAction feedsToggleAction = new FeedsToggleAction();
        feedsToggleAction.setValue(toggleValue);
        return feedsToggleAction;
    }

    private FeedsActionValue getFollowActionValue() {
        return new FeedsActionValue(FOLLOW, getFollowAction());
    }

    private FeedsToggleAction getFollowAction() {
        RichTextValue follow = new RichTextValue();
        follow.setText("Follow");
        follow.setTextColor(selectedColorCode);

        RichTextValue followed = new RichTextValue();
        followed.setText("UnFollow");
        followed.setTextColor(selectedColorCode);

        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey(getSharedKey(SharedKeyEnum.PERSONA_FOLLOW_SELECTED));

        ToggleValue<ActionContentValue> toggleValue = new ToggleValue<>(widgetSharedDataKey,
                getPostActionContentRC(InteractionType.FOLLOW, follow), getPostActionContentRC(InteractionType.UNFOLLOW, followed));
        FeedsToggleAction feedsToggleAction = new FeedsToggleAction();
        feedsToggleAction.setValue(toggleValue);
        return feedsToggleAction;
    }

    RenderableComponent<FeedsPersonaProfile> getPostCreatorRC() {
        RichTextValue creatorTitle = new RichTextValue();
        creatorTitle.setTitle("Nike");
        creatorTitle.setText("Nike");
        RichTextValue creatorSubTitle = new RichTextValue();
        creatorSubTitle.setText("6 hrs ago");
        creatorSubTitle.setTitle("6 hrs ago");
        FeedsToggleAction postActionRenderableComponent = getFollowAction();
        FeedsPersonaProfile profile = new FeedsPersonaProfile(true);
        profile.setIcon(new RenderableComponent<>(null, getImageValue()));
        profile.setFollow(postActionRenderableComponent);
        profile.setTitle(new RenderableComponent<>(null, creatorTitle));
        profile.setSubTitle(Collections.singletonList(new RenderableComponent<>(null, creatorSubTitle)));
        return new RenderableComponent<>(getAction(feedsPersonaUrl), profile);
    }

    private Action getAction(String url, InteractionType interactionType) {
        Action action = getAction(url);
        Map<String, Object> params = new HashMap<>();
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("entityId", getPostId());
        reqMap.put("interactionType", interactionType.toString());
        params.put("request", reqMap);
        action.setParams(params);
        return action;
    }

    private Action getAction(String url) {
        Action action;
        switch (url) {
            case feedsPersonaUrl:
                action = new Action();
                action.setLoginType(LoginType.LEGACY_LOGIN);
                action.setOriginalUrl(url);
                action.setUrl("http://www.flipkart.com" + url);
                return action;
            case feedsInteractionUrl:
                action = new Action();
                action.setLoginType(LoginType.LEGACY_LOGIN);
                action.setOriginalUrl(url);
                action.setUrl("http://www.flipkart.com" + url);
                return action;
            default:
                return new Action();

        }
    }

    FeedsProfileCard getFeedsPersonaProfileCard() {
        FeedsPersonaProfile feedsPersonaProfile = new FeedsPersonaProfile();
        feedsPersonaProfile.setFollow(getFollowAction());
        feedsPersonaProfile.setVerified(true);

        RichTextValue title = new RichTextValue();
        title.setText("Nike");
        feedsPersonaProfile.setTitle(new RenderableComponent<>(null, title));

        RichTextValue subTitle = new RichTextValue();
        subTitle.setText("Top class shoes");
        feedsPersonaProfile.setSubTitle(Collections.singletonList(new RenderableComponent<>(null, subTitle)));

        RichButtonValue selectedButtonValue = new RichButtonValue();
        selectedButtonValue.setTitle("Follow");
        selectedButtonValue.setButtonColor(selectedColorCode);
        RichButtonValue unselectedButtonValue = new RichButtonValue();
        unselectedButtonValue.setTitle("Following");
        selectedButtonValue.setButtonTextColor(selectedColorCode);

        FeedsProfileCard profileCard = new FeedsProfileCard();
        profileCard.setProfile(feedsPersonaProfile);
        profileCard.setPreviewContent(Collections.singletonList(new RenderableComponent<>(null, getFeedsImage())));

        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey("isPersonaFollowed");

        profileCard.setToggleButton(new ToggleValue<>(widgetSharedDataKey,
                new RenderableComponent<>(null, selectedButtonValue),
                new RenderableComponent<>(null, unselectedButtonValue)));
        return profileCard;
    }

    FeedsProfileCard getFeedsInterestsProfileCard() {
        FeedsInterestProfile feedsInterestProfile = new FeedsInterestProfile();

        RichTextValue title = new RichTextValue();
        title.setText("Travel");
        feedsInterestProfile.setTitle(new RenderableComponent<>(null, title));

        RichTextValue subTitle = new RichTextValue();
        feedsInterestProfile.setSubTitle(Collections.singletonList(new RenderableComponent<>(null, subTitle)));

        RichButtonValue selectedButtonValue = new RichButtonValue();
        selectedButtonValue.setTitle("Add");
        selectedButtonValue.setButtonColor(selectedColorCode);
        RichButtonValue unselectedButtonValue = new RichButtonValue();
        unselectedButtonValue.setTitle("Added");
        unselectedButtonValue.setButtonTextColor(selectedColorCode);

        WidgetSharedDataKey<Boolean> widgetSharedDataKey = new WidgetSharedDataKey<>();
        widgetSharedDataKey.setSharedDataKey("isInterestAdded");

        FeedsProfileCard profileCard = new FeedsProfileCard();
        profileCard.setProfile(feedsInterestProfile);
        profileCard.setToggleButton(new ToggleValue<>(widgetSharedDataKey,
                new RenderableComponent<>(null, selectedButtonValue),
                new RenderableComponent<>(null, unselectedButtonValue)));
        return profileCard;
    }
}
