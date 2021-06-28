package com.example.demo.translation.domain.entity;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Translation {

    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "translation", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<TranslationsText> translationsText;


    public static Translation createTranslation(String text, String isoCode) {
        Translation translation = new Translation();
        TranslationsText translationsText = new TranslationsText();
        translationsText.setText(text);
        translationsText.setIsoCode(isoCode);
        translationsText.setTranslation(translation);
        translation.setTranslationsText(Collections.singletonList(translationsText));
        return translation;
    }

    public String getTextByIsoCode(String isoCode) {
        if (translationsText == null) {
            return Strings.EMPTY;
        } else {
            return translationsText.stream()
                    .filter(x -> isoCode.equals(x.getIsoCode()))
                    .findFirst().orElseGet(this::getDefaultTranslation).getText();
        }
    }

    private TranslationsText getDefaultTranslation(){
        return translationsText.stream()
                .filter(x -> "en".equals(x.getIsoCode()))
                .findFirst().orElseThrow();
    }

    @Override
    public String toString() {
        return "";
    }
}
