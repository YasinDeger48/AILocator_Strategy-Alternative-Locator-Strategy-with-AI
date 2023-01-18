package qa.virgosol.test.AI.helper;

import javax.annotation.Nullable;

public class ElementModel {
    @Nullable
    private String className;
    @Nullable
    private String Id;
    @Nullable
    private String textValue;
    @Nullable
    private String name;
    @Nullable
    private String style;
    @Nullable
    private String title;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
