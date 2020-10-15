package com.stefanini.etlypfcc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;

import com.stefanini.etlypfcc.model.Fact_ticket_abierto;
import com.stefanini.etlypfcc.model.FileQ;



@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Bean
	public FlatFileItemReader<FileQ> fileItemReader(){
		FlatFileItemReader<FileQ> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/abiertos-q.csv"));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<FileQ> itemReader, ItemProcessor<FileQ,Fact_ticket_abierto> itemProcessor,
			ItemWriter<Fact_ticket_abierto> itemWriter) {
		
		Step step = stepBuilderFactory.get("ETL-file-load")
				.<FileQ,Fact_ticket_abierto>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
		return jobBuilderFactory.get("ETL-Load")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
		
	}
	
	
	@Bean
	public LineMapper<FileQ> lineMapper(){
		
		DefaultLineMapper<FileQ> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer= new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"Prioridad","Numero","DtoAsignado","Solicitadopor","Fechaapertura"});
		
		BeanWrapperFieldSetMapper<FileQ> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(FileQ.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}

}
