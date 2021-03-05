package com.unico.community.online.postCatgTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
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

    @Before
    public void setup(){

    }

    @After
    public void tearDown(){

    }

}
