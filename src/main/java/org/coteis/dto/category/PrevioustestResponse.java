package org.coteis.dto.category;

import lombok.Getter;
import org.coteis.domain.category.Previoustest;

@Getter
public class PrevioustestResponse {
    private final Integer previoustestNo;
    private final String previoustestName;

    public PrevioustestResponse(Previoustest previoustest) {
        this.previoustestNo = previoustest.getPrevioustestNo();
        this.previoustestName = previoustest.getPrevioustestName();
    }
}
