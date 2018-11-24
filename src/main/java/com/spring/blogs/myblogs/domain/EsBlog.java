package com.spring.blogs.myblogs.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 博客文档类
 */

//表示文档
@Document(indexName = "blog",type = "blog")
public class EsBlog implements Serializable {

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog(){

    }
    //有参构造
    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return String.format("EsBlog[id=%s, title='%s',summary='%s', content='%s']", id, title, summary,content);
    }
}
