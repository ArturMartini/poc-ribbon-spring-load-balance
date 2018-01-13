package br.com;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class RibbonApplication {
	
	@Autowired
	private Environment environment;

	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping("/health")
	public HttpStatus health() {
		return HttpStatus.OK;
	}

	@CrossOrigin(origins="*")
	@RequestMapping("/clientLoadBalance")
	private String clientCallServiceRibbon() {
        ServiceInstance instance = loadBalancer.choose("microservice-load-balance");
        URI serviceUri = URI.create(String.format("http://%s:%s/server", instance.getHost(), instance.getPort()));
        return restTemplate.getForEntity(serviceUri, String.class).getBody();
    }
	
	@CrossOrigin(origins="*")
	@RequestMapping("/server")
	private String serverReceiveCall() {
		
		String address = "";
		
		try {
			address = InetAddress.getLocalHost().getHostName() + ":" + environment.getProperty("local.server.port");
		} catch (UnknownHostException e) {
			//nothingmvn
		}
		
		return address;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
