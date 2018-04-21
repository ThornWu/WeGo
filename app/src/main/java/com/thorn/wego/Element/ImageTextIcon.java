package com.thorn.wego.Element;

public class ImageTextIcon {
    private int iconId;
    private String iconName;

    public ImageTextIcon(){}
    public ImageTextIcon(int iconId, String iconName){
        this.iconId = iconId;
        this.iconName = iconName;
    }

    public int getIconId(){
        return iconId;
    }
    public String getIconName(){
        return iconName;
    }

    public void setIconId(int iconId){
        this.iconId = iconId;
    }
    public void setIconName(String iconName){
        this.iconName = iconName;
    }
}
