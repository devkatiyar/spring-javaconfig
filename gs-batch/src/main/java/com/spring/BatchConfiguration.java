package com.spring;

import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.model.Person;
import com.processor.JobCompletionNotificationListener;
import com.processor.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
@Import(DataSourceConfiguration.class)
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	JobCompletionNotificationListener listener;

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public FlatFileItemReader<Person> reader() {
		FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
		reader.setResource(new ClassPathResource("sample-data.csv"));
		reader.setLineMapper(new DefaultLineMapper<Person>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
					{
						setTargetType(Person.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public HibernateItemWriter<Person> writer() {
		HibernateItemWriter<Person> hibernateItemWriter = new HibernateItemWriter<Person>();
		hibernateItemWriter.setSessionFactory(sessionFactory);
		return hibernateItemWriter;
	}
	// @Bean
	// public Job processOrderJob(JobCompletionNotificationListener listener) {
	// return jobBuilderFactory.get("importUserJob")
	// .incrementer(new RunIdIncrementer())
	// .listener(listener)
	// .flow(step1())
	// .end()
	// .build();
	// }

	@Bean(name = "executionSteps")
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person>chunk(10).reader(reader()).processor(processor())
				// .writer(writer())
				.build();
	}

	@Bean(name = "executionSteps")
	public Step step2() {
		return stepBuilderFactory.get("step2").<Person, Person>chunk(10).writer(writer()).build();
	}

	// public Flow
	// Flow subflow1 = new FlowBuilder<Flow>("subflow1").from(step2).end();
	// Flow subflow2 = new FlowBuilder<Flow>("subflow2").from(step3).end();
	// Flow splitflow = new
	// FlowBuilder<Flow>("splitflow").start(subflow1).split(new
	// SimpleAsyncTaskExecutor())
	// .add(subflow2).build();
	//

	@Bean
	public Job job() {

		return jobBuilderFactory.get("job").flow(step1()).on("COMPLETED").to(step2()).end().build();

		// return
		// jobBuilderFactory.get("job").flow(step1()).on("COMPLETED").to(step2()).
		// end().build();
	}
}
