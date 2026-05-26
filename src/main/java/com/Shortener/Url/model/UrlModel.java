package com.Shortener.Url.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import java.time.LocalDateTime;

@Entity@Table(name = "UrlEncurta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UrlModel {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    @Column(nullable = false)
    private String urlOriginal;

    @Column(nullable = false, unique = true)
    private String urlCurta;

    @Column(name = "gerado_em")
    private LocalDateTime geradoEm = LocalDateTime.now();

}