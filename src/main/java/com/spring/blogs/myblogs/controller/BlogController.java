package com.spring.blogs.myblogs.controller;

import com.spring.blogs.myblogs.domain.EsBlog;
import com.spring.blogs.myblogs.repository.EsBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRepo esBlogRepo;

    @GetMapping
    public List<EsBlog> list(
            @RequestParam(value="title") String title,
            @RequestParam(value="summary") String summary,
            @RequestParam(value="content") String content,
            @RequestParam(value="pageIndex",defaultValue = "0") int pageIndex,
            @RequestParam(value="pageSize",defaultValue = "10") int pageSize) {

        //数据使用测试用例的方法
        //因此启动之后先运行一下测试用例
        Pageable pageable = new PageRequest(pageIndex,pageSize);
        Page<EsBlog> page = esBlogRepo.findDistinctEsBlogByTitleOrSummaryOrContent(title, summary, content, pageable);
        return page.getContent();

    }
}
