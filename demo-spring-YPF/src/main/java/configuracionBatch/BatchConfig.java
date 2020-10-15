package configuracionBatch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Modelo.TicketAbierto;

@Configuration
public class BatchConfig {

@Bean
	
public Job job(JobBuilderFactory jobBuilderFactory, 
		StepBuilderFactory stepBuilderFactory, 
		ItemReader<TicketAbierto> itemReader, 
		ItemProcessor<TicketAbierto, TicketAbierto> itemProcessor,
		ItemWriter<TicketAbierto> itemWriter ) {
	
	Step step= stepBuilderFactory.get("ETL - Carga Archivo").
			<TicketAbierto, TicketAbierto>chunk(100).
			reader(itemReader).
			processor(itemProcessor).
			writer(itemWriter).
			build(); 
	
	
	Job job = jobBuilderFactory.get("ETL - Load").incrementer(new RunIdIncrementer()).start(step).build();
	
	return job;
} 

@Bean

private String ruta = "C:\\Users\\Usuario\\Downloads\\abiertos-im.csv";
public FlatFileItemReader <ruta> fileItemReader(@value("${input}") Resourse resourse){
	
	FlatFileItemReader <ruta>
}
}
