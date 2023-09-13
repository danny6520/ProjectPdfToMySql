package com.pdftomysql;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<PdfData> pdfItemReader;
    @Autowired
    private ItemWriter<PdfData> databaseItemWriter;

    @Bean
    public Job pdfToDatabaseJob() {
        return jobBuilderFactory.get("pdfToDatabaseJob")
                .start(importPdfFileStep())
                .build();
    }

    @Bean
    public Step importPdfFileStep() {
        return stepBuilderFactory.get("importPdfFileStep")
                .<PdfData, PdfData>chunk(10)
                .reader(pdfItemReader)
                .processor(pdfDataProcessor())
                .writer(databaseItemWriter)
                .build();
    }

    @Bean
    public ItemProcessor<PdfData, PdfData> pdfDataProcessor() {
        return pdfData -> {
            // You can add any data processing logic here if needed
            return pdfData;
        };
    }
    
    @Bean
    public ItemReader<PdfData> pdfItemReader() {
        PdfItemReader<PdfData> reader = new PdfItemReader<>();
        reader.setResource(new ClassPathResource("AC183.pdf")); // Path to your PDF file
        reader.setRowMapper(pdfDataRowMapper());
        return reader;
    }

    @Bean
    public RowMapper<PdfData> pdfDataRowMapper() {
        return new PdfDataRowMapper();
    }

    @Bean
    public ItemWriter<PdfData> databaseItemWriter(EntityManagerFactory entityManagerFactory) {
        JpaItemWriter<PdfData> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

    
}


