package kr.co.wlife.fac.jhb.batch.processor;

import kr.co.wlife.fac.jhb.batch.bean.item.TestItem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestItemProcessorConfig {

    @Bean
    public ItemProcessor<TestItem, TestItem> testItemProcessor() {
        return item -> {
            TestItem processed = new TestItem(item.getCol1().toUpperCase());
            System.out.println("Processing: " + item.getCol1() + " -> " + processed.getCol1());
            return processed;
        };
    }
}