package kr.co.wlife.fac.jhb.batch.writer;

import kr.co.wlife.fac.jhb.batch.bean.item.TestItem;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestItemWriterConfig {

    @Bean
    public MyBatisBatchItemWriter<TestItem> testItemWriter(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisBatchItemWriterBuilder<TestItem>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("kr.co.wlife.fac.jhb.batch.mapper.TestMapper.insertTestItem")
                .itemToParameterConverter(item -> java.util.Map.of("item", item))
                .build();
    }
}