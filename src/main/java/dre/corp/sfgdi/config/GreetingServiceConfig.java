package dre.corp.sfgdi.config;

import dre.corp.pets.PetService;
import dre.corp.pets.PetServiceFactory;
import dre.corp.sfgdi.datasource.FakeDataSource;
import dre.corp.sfgdi.repositories.EnglishGreetingRepository;
import dre.corp.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import dre.corp.sfgdi.services.ConstructorGreetingService;
import dre.corp.sfgdi.services.I18nEnglishGreetingService;
import dre.corp.sfgdi.services.PropertyInjectedGreetingService;
import dre.corp.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

//leaving this example in the code
//@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

//    @Profile("EN")
//    @Bean
//    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
//        return new I18nEnglishGreetingService(englishGreetingRepository);
//    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
