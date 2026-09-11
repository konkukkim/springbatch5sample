package kr.co.wlife.fac.jhb.batch.step;

import kr.co.wlife.fac.jhb.batch.bean.item.TestItem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TestChunkStepConfig {

    @Bean
    public Step testChunkStep(JobRepository jobRepository,
                              PlatformTransactionManager transactionManager,
                              ItemReader<TestItem> testItemReader,
                              ItemProcessor<TestItem, TestItem> testItemProcessor,
                              ItemWriter<TestItem> testItemWriter) {
        return new StepBuilder("testChunkStep", jobRepository)
                .<TestItem, TestItem>chunk(2, transactionManager)  // 2건씩 묶어서 commit
                .reader(testItemReader)
                .processor(testItemProcessor)
                .writer(testItemWriter)
                .build();
    }
}