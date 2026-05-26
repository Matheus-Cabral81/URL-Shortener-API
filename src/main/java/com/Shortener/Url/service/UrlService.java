package com.Shortener.Url.service;
import com.Shortener.Url.exception.UrlNotFoundException;
import com.Shortener.Url.model.UrlModel;
import com.Shortener.Url.repository.UrlRepository;
import org.springframework.stereotype.Service;
import java.util.List;import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public UrlModel encurtar(String urlOriginal){

        String codigoCurto = UUID.randomUUID().toString().substring(0,8);
        UrlModel entity = new UrlModel();

        entity.setUrlOriginal(urlOriginal);
        entity.setUrlCurta(codigoCurto);

        return urlRepository.save(entity);
    }
    public UrlModel buscarPorCodigo(String urlCurta){

        return urlRepository.findByUrlCurta(urlCurta)
                .orElseThrow(() -> new UrlNotFoundException(urlCurta));
    }

    public List<UrlModel> listarTodas() {

        return urlRepository.findAll();
    }
}