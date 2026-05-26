package com.Shortener.Url.repository;
import com.Shortener.Url.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Long>{

    Optional<UrlModel> findByUrlCurta(String urlCurta);

}