package edu.umkc.tammabathular.elasticsearchspringbatch.itemreaders;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import edu.umkc.tammabathular.elasticsearchspringbatch.models.CausesOfDeath;

public class DeathCausesReader implements ItemReader<CausesOfDeath> {

	public String filename;

	public DeathCausesReader(String filename) {
		// TODO Auto-generated constructor stub
		this.filename = filename;

	}

	@Override
	public CausesOfDeath read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		FlatFileItemReader<CausesOfDeath> fileReader = new FlatFileItemReader<CausesOfDeath>();
		fileReader.setResource(new ClassPathResource(filename));
		CausesOfDeath causesOfDeath = new CausesOfDeath();
		fileReader.setLineMapper(new DefaultLineMapper<CausesOfDeath>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] {"Year","Cause Name desc","Cause Name","State","Deaths,Age-adjusted Death Rate"});
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<CausesOfDeath>() {
					{
						setTargetType(CausesOfDeath.class);
					}
				});
			}
		});
		
		causesOfDeath = fileReader.read();

		return causesOfDeath;
	}

}
