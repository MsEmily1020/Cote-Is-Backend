package org.coteis.dto;

import lombok.Getter;
import org.coteis.domain.Previoustest;

@Getter
public class PrevioustestResponse {
    private final int previoustestNo;
    private final String previoustestName;

    public PrevioustestResponse(Previoustest previoustest) {
        this.previoustestNo = previoustest.getPrevioustestNo();
        this.previoustestName = previoustest.getPrevioustestName();
    }
}
