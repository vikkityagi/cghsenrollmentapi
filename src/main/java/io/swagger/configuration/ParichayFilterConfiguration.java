package io.swagger.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.filters.ParichayTokenAuthFilter;

@Configuration
public class ParichayFilterConfiguration {

    @Autowired
    private ParichayTokenAuthFilter parichayTokenAuthFilter;

    @Bean
    public FilterRegistrationBean<ParichayTokenAuthFilter> myFilterRegistration() {
        FilterRegistrationBean<ParichayTokenAuthFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(parichayTokenAuthFilter);
        registration.addUrlPatterns("/*"); // Apply the filter to all requests
        registration.setName("ParichayTokenAuthFilter");
        registration.setOrder(1); // Set the order in which filters are applied
        return registration;
    }
}

