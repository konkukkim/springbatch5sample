package kr.co.wlife.fac.jhb.batch.reader;

import kr.co.wlife.fac.jhb.batch.bean.item.TestItem;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestItemReaderConfig {

    @Bean
    public MyBatisCursorItemReader<TestItem> testItemReader(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisCursorItemReaderBuilder<TestItem>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("kr.co.wlife.fac.jhb.batch.mapper.TestMapper.findAllTestItems")
                .build();
    }
}