package qa.virgosol.test.AI.model;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.annotation.Nullable;

public class YAMLModel {

    @Nullable
    private String elementType;
    @Nullable
    private String yourLocator;
    @Nullable
    private String yourLocatorType;
    @Nullable
    private String testURL;
    @Nullable
    private String browserType;

    @Nullable
    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(@Nullable String browserType) {
        this.browserType = browserType;
    }

    public boolean isHeadless() {
        return headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    @Nullable
    private boolean headless;

    @Nullable
    public String getElementType() {
        return elementType;
    }

    public void setElementType(@Nullable String elementType) {
        this.elementType = elementType;
    }

    @Nullable
    public String getYourLocator() {
        return yourLocator;
    }

    public void setYourLocator(@Nullable String yourLocator) {
        this.yourLocator = yourLocator;
    }

    @Nullable
    public String getYourLocatorType() {
        return yourLocatorType;
    }

    public void setYourLocatorType(@Nullable String yourLocatorType) {
        this.yourLocatorType = yourLocatorType;
    }

    @Nullable
    public String getTestURL() {
        return testURL;
    }

    public void setTestURL(@Nullable String testURL) {
        this.testURL = testURL;
    }
}
