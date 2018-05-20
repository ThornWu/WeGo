package com.thorn.wego.Element;

import java.util.List;

public class PositionListJson {
    private String text;
    private String code;
    private List<PositionListItem> result;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PositionListItem> getResult() {
        return result;
    }

    public void setResult(List<PositionListItem> result) {
        this.result = result;
    }
}
