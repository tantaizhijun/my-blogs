package com.spring.blogs.myblogs.repository;


import com.spring.blogs.myblogs.domain.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * EsBlogRepo的相关方法测试用例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepoTest {

    @Autowired
    private EsBlogRepo esBlogRepo;

    //执行测试用例之前,先删除所有文档
    @Before
    public void initRepositoryData(){
        esBlogRepo.deleteAll();
        esBlogRepo.save(new EsBlog("测试title","测试summary","测试内容"));
    }

    @Test
    public void testFindDistinctEsBlogByTitleOrSummaryOrContent(){
        Pageable pageable = new PageRequest(0, 20);
        Page<EsBlog> page = esBlogRepo.findDistinctEsBlogByTitleOrSummaryOrContent("试","试","试",pageable);
        System.out.println("----start");
        for(EsBlog b : page) {
            System.out.println(b.toString());
        }
        System.out.println("----end");
    }


}


