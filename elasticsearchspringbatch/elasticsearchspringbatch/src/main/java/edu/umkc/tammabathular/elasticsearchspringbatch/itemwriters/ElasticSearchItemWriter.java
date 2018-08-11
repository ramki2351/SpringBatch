package edu.umkc.tammabathular.elasticsearchspringbatch.itemwriters;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import edu.umkc.tammabathular.elasticsearchspringbatch.models.CausesOfDeath;
import edu.umkc.tammabathular.elasticsearchspringbatch.utils.CreateElasticsearchClient;
import edu.umkc.tammabathular.elasticsearchspringbatch.utils.ReadAndLoadPropertyFiles;

public class ElasticSearchItemWriter implements ItemWriter<String> {


	@Autowired
	public CreateElasticsearchClient createElasticsearchClient;

	@Autowired
	public ReadAndLoadPropertyFiles readAndLoadPropertyFiles;
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub

		TransportClient client = null;
		try {

			client = createElasticsearchClient.returnTransportClient();
			
			IndexResponse indexResponse = client.prepareIndex(readAndLoadPropertyFiles.getIndex(), readAndLoadPropertyFiles.getType()).setSource("").get();
			System.out.println(indexResponse.getResult());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
