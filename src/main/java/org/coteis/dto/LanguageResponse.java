package org.coteis.dto;

import lombok.Getter;
import org.coteis.domain.Language;

@Getter
public class LanguageResponse {
    private final Integer languageNo;
    private final String languageName;

    public LanguageResponse(Language language) {
        this.languageNo = language.getLanguageNo();
        this.languageName = language.getLanguageName();
    }
}
