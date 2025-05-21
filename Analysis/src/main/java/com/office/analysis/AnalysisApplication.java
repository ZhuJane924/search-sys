package com.office.analysis;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AnalysisApplication {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job paperJob;

    public static void main(String[] args) {
        SpringApplication.run(AnalysisApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void runJob() throws Exception {
        var jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        var jobExecution = jobLauncher.run(paperJob, jobParameters);
        System.out.println("Job Status : " + jobExecution.getStatus());
    }
}
