package com.thorn.wego.PositionDetail.Model;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.PositionDetailJson;

public interface IPositionInfo {
    PositionDetailJson getPositionDetail(String url);
    BasicNetworkJson doOperation(String url);
}
