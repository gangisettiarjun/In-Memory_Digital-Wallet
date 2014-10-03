package com.voldy.main;

import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.voldy.cacheImpl.SimpleUserRepo;
import com.voldy.cacheInteface.IUserRepo;

@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableCaching
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users");
    }
*/
	@Bean
    public IUserRepo bookRepository() {
        return new SimpleUserRepo();
    }
	@Bean
    public Filter  etagFilter() {
		ShallowEtagHeaderFilter shallowEtagHeaderFilter = new ShallowEtagHeaderFilter();
		return shallowEtagHeaderFilter;
    }
	
}
