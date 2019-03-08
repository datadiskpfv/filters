package uk.co.datadisk.filters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan       // used for @WebFilter
@SpringBootApplication
public class FiltersApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiltersApplication.class, args);
    }

}
