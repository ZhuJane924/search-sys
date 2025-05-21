package com.office.analysis.batch.job;

import com.office.analysis.batch.step.PaperItemProcessor;
import com.office.analysis.batch.step.PaperItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import com.office.analysis.entity.Paper;

@Configuration
@EnableBatchProcessing
public class PaperJobConfig {

    @Bean
    public Job paperJob(JobRepository jobRepository,
                        Step paperStep) {
        return new JobBuilder("paperJob", jobRepository)
                .start(paperStep)
                .build();
    }

    @Bean
    public Step paperStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          JdbcPagingItemReader<Paper> paperItemReader,
                          PaperItemProcessor paperItemProcessor,
                          PaperItemWriter paperItemWriter) {
        return new StepBuilder("paperStep", jobRepository)
                .<Paper, Paper>chunk(100, transactionManager)
                .reader(paperItemReader)
                .processor(paperItemProcessor)
                .writer(paperItemWriter)
                .build();
    }
}
