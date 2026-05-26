package com.Shortener.Url.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class UrlResponse {
    private String urlOriginal;

    private String urlCurta;

    private String geradoEm;

}