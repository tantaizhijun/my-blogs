package com.spring.blogs.myblogs.repository;

import com.spring.blogs.myblogs.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es资源库 接口
 */
public interface EsBlogRepo extends ElasticsearchRepository<EsBlog,String> {

    //分页查询博客
    Page<EsBlog> findDistinctEsBlogByTitleOrSummaryOrContent(String title, String summary, String content, Pageable pageable);

}
