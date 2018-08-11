package edu.umkc.tammabathular.elasticsearchspringbatch.utils;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateElasticsearchClient {

	@Autowired
	public ReadAndLoadPropertyFiles loadPropertyFiles;

	@Bean
	public TransportClient returnTransportClient() {

		Settings settings = Settings.builder().put("cluster.name", loadPropertyFiles.getClusterName()).build();
		TransportClient client = null;
		PreBuiltTransportClient preBuiltTransportClient = null;
		try {
			preBuiltTransportClient = new PreBuiltTransportClient(settings);
			client = preBuiltTransportClient.addTransportAddress(
					new InetSocketTransportAddress(InetAddress.getByName(loadPropertyFiles.getHost()), loadPropertyFiles.getPort()));
						
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		

		return client;
	}

}
