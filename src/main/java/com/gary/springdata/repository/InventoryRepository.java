package com.gary.springdata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gary.springdata.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InventoryRepository extends ElasticsearchRepository<Article, String> {
    Page<Article> findByAuthorsName(String name, Pageable pageable);

    /**
     * Using a custom Elasticsearch boolean query defined using the @Query annotation,
     * which requires stric matching between the author's name and the provided name argument.
     *
     * @param name
     * @param pageable
     * @return
     */
    @Query("{\"bool\": {\"must\":[{\"match\": {\"autors.name\":\"?0\"}}]})")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
    Page<Article> findByFilteredTagQuery(String tag, Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
    Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable);
}
