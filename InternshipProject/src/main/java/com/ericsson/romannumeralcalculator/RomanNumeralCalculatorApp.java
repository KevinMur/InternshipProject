package com.ericsson.romannumeralcalculator;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ericsson.romannumeralcalculator.operations.OperationFactory;

/**
 * @author ekvumer
 *
 *         Class to run the spring boot application.
 *
 */
@SpringBootApplication
public class RomanNumeralCalculatorApp {
    public static void main(final String[] args) {
        SpringApplication.run(RomanNumeralCalculatorApp.class, args);
    }

    /**
     * Creates a factory for classes that implement the Operation interface
     *
     * @return the factory
     */
    @Bean
    public ServiceLocatorFactoryBean serviceLocatorBean() {
        final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(OperationFactory.class);
        return bean;
    }
}