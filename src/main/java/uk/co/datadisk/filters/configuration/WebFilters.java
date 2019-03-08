package uk.co.datadisk.filters.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import uk.co.datadisk.filters.configuration.filters.ABCFilter;
import uk.co.datadisk.filters.configuration.filters.ONEFilter;
import uk.co.datadisk.filters.configuration.filters.XYZFilter;

@Configuration
public class WebFilters {

    //Register ABCFilter
    @Bean
    public FilterRegistrationBean<ABCFilter> abcFilter() {
        FilterRegistrationBean<ABCFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new ABCFilter());
        filterRegBean.addUrlPatterns("/index/*");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
        return filterRegBean;
    }
    //Register XYZFilter
    @Bean
    public FilterRegistrationBean<XYZFilter> xyzFilter() {
        FilterRegistrationBean<XYZFilter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new XYZFilter());
        filterRegBean.addUrlPatterns("/app/*");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -2);
        return filterRegBean;
    }

//    //Register ONEFilter
//    @Bean
//    public FilterRegistrationBean<ONEFilter> oneFilter() {
//        FilterRegistrationBean<ONEFilter> filterRegBean = new FilterRegistrationBean<>();
//        filterRegBean.setFilter(new ONEFilter());
//        filterRegBean.addUrlPatterns("/one/*");
//        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -3);
//        return filterRegBean;
//    }
}
