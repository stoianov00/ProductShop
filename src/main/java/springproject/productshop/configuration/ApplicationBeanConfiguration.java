package springproject.productshop.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springproject.productshop.util.impl.FileUtilImpl;
import springproject.productshop.util.impl.ValidatorUtilImpl;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FileUtilImpl fileUtil() {
        return new FileUtilImpl();
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ValidatorUtilImpl validatorUtil() {
        return new ValidatorUtilImpl(this.validator());
    }

}
