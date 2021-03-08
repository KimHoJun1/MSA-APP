package com.unico.community.online.postCatgTest;


import com.unico.community.online.postCatg.service.PostCatgService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostCatgTest {
    @Rule
    public final TestName testName = new TestName();

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private PostCatgService service;


    @Before
    public void setup(){
        switch ( testName.getMethodName() ){
            case "findAll_test_01" :
                bacthUpdateQuery("" +
                        "insert into " +
                        "(POST_CATG_UUID, POST_CATG_NM, POST_CATG_USE_YN, REGN_NM) " +
                        "valuess ('test', 'test', 1, '경기도');");
                break;
        }
    }

    @After
    public void tearDown(){
        switch ( testName.getMethodName() ){
            case "findAll_test_01" :
                bacthUpdateQuery("" +
                        "delete from " +
                        "TB_POST_CATG_M  " +
                        "where POST_CATG_UUID = 'test' and POST_CATG_NM = 'test'and POST_CATG_USE_YN = 1 and REGN_NM = '경기도';");
                break;
        }
    }


    @Test
    public void findAll_test_01() throws Exception{
        Assertions.assertThat(
            service.findAll().stream().allMatch(postCatgDTO -> {
                return postCatgDTO.getPostCatgUuid().equals("test") &&
                        postCatgDTO.getPostCatgNm().equals("test") &&
                        postCatgDTO.isPostCatgUseYn() == true &&
                        postCatgDTO.getRegnNm().equals("경기도");
            })
        );
    }


    private void bacthUpdateQuery(String sqls){
        template.batchUpdate(sqls.split(";"));
    }
}
