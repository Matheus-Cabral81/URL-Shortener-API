package com.Shortener.Url.controller;
import com.Shortener.Url.dto.request.UrlRequest;
import com.Shortener.Url.model.UrlModel;
import com.Shortener.Url.service.UrlService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController@RequestMapping("/api/urls")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;

    }

    @PostMapping
    public ResponseEntity<UrlModel> encurtar(@RequestBody UrlRequest request){
        UrlModel resultado = urlService.encurtar(request.getUrlOriginal());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UrlModel> buscar(@PathVariable String codigo){
        UrlModel resultado = urlService.buscarPorCodigo(codigo);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<UrlModel>> listarTodas(){
        return ResponseEntity.ok(urlService.listarTodas());
    }

    @GetMapping("/redirect/{codigo}")
    public ResponseEntity<Void> redirecionar(@PathVariable String codigo){
        UrlModel url = urlService.buscarPorCodigo(codigo);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", url.getUrlOriginal())
                .build();
    }
}