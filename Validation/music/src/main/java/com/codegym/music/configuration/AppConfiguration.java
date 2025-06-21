package com.codegym.music.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.codegym.music")
public class AppConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //Thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }



    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new ProvinceFormatter(applicationContext.getBean(ProvinceService.class)));
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("validation-message");
        return messageSource;
    }

//    @Bean
//    public LocalValidatorFactoryBean validatorFactory(ApplicationContext context) {
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        factoryBean.setConstraintValidatorFactory(
//                new SpringConstraintValidatorFactory(context.getAutowireCapableBeanFactory())
//        );
//        return factoryBean;
//    }
//
//    @Override
//    public org.springframework.validation.Validator getValidator() {
//        return validatorFactory(null); // hoặc truyền ApplicationContext nếu cần
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor(Validator validator) {
//        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
//        processor.setValidator(validator);
//        return processor;
//    }

}
