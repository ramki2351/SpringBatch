package edu.umkc.tammabathular.elasticsearchspringbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.umkc.tammabathular.elasticsearchspringbatch.models.CausesOfDeath;

public class DeathCausesProcessor implements ItemProcessor<CausesOfDeath, String> {

	@Override
	public String process(CausesOfDeath item) throws Exception {
		// TODO Auto-generated method stub

		CausesOfDeath causesOfDeath = new CausesOfDeath();
		ObjectMapper objectMapper = new ObjectMapper();
		causesOfDeath.setYear(item.getYear());
		causesOfDeath.setDeaths(item.getDeaths());
		causesOfDeath.setCauseName(item.getCauseName());
		causesOfDeath.setCauseNameDesc(item.getCauseNameDesc());
		causesOfDeath.setState(item.getState());
		causesOfDeath.setAgeAdjustedDeathRate(item.getAgeAdjustedDeathRate());


		return objectMapper.writeValueAsString(causesOfDeath);

	}

}
