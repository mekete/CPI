package edu.uw.cpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@CacheConfig(cacheNames = "BLSResponse")
@SpringBootApplication
public class BlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlsApplication.class, args);
	}

}
