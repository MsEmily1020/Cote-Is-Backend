package org.coteis.dto.category;

import lombok.Getter;
import org.coteis.domain.category.Language;

@Getter
public class LanguageResponse {
    private final Integer languageNo;
    private final String languageName;

    public LanguageResponse(Language language) {
        this.languageNo = language.getLanguageNo();
        this.languageName = language.getLanguageName();
    }
}
