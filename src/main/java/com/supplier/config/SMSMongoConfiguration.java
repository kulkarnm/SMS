package com.supplier.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.supplier.convertors.LocalDateTimeToStringConverter;
import com.supplier.convertors.LocalDateToStringConverter;
import com.supplier.convertors.StringToLocalDateConverter;
import com.supplier.convertors.StringToLocalDateTimeConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories( basePackages = "com.supplier.repositories",mongoTemplateRef = "smsMongoTemplate")
public class SMSMongoConfiguration {
    @Bean
    @Qualifier(value="smsMongoTemplate")
    @Primary
    public MongoTemplate smsMongoTemplate(@Qualifier("smsMongoDbFactory") MongoDbFactory factory,@Qualifier("smsMappingMongoConverter") MappingMongoConverter mappingMongoConverter) {
        System.out.println("###INside SMSMongoTemplate creation " + factory.getDb().getName());
        MongoTemplate mongoTemplate = new MongoTemplate(factory,mappingMongoConverter);
        return mongoTemplate;
    }

    @Bean
    @Qualifier(value="smsMongo")
    public MongoClient smsMongo(@Qualifier("smsMongoClientURI") MongoClientURI mongoClientURI) throws UnknownHostException {
        System.out.println("###INside MOngoClient creation");
        return new MongoClient(mongoClientURI);
    }

    @Bean
    @Qualifier(value="smsMongoClientURI")
    public MongoClientURI productMongoClientURI(@Value("${view.db.sms.host}") String host, @Value("${view.db.sms.port}") int port,
                                         @Value("${view.db.sms.name}") String dbName,
                                         @Value("${sms.db.username}") String username,
                                         @Value("${sms.db.password}") String password) {

        return new MongoClientURI("mongodb://" /*+ username + ":" + password + "@" */
                + host
                + ":"
                + port
                + "/" +
                dbName);
    }

    @Bean
    @Qualifier(value="smsMongoDbFactory")
    public MongoDbFactory smsMongoDbFactory(@Value("${view.db.sms.host}") String host, @Value("${view.db.sms.port}") int port,
                                                @Value("${view.db.sms.name}") String dbName) throws UnknownHostException {
        System.out.println("###INside mongoDbFactory creation");
        return new SimpleMongoDbFactory(new MongoClient(new ServerAddress(host, port)), dbName);
    }

    @Bean
    @Qualifier(value="smsCustomConversions")
    public CustomConversions smsCustomConversions(){
        List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
        converters.add(new LocalDateToStringConverter());
        converters.add(new LocalDateTimeToStringConverter());
        converters.add(new StringToLocalDateConverter());
        converters.add(new StringToLocalDateTimeConverter());
        return new CustomConversions(converters);
    }

    @Bean
    @Qualifier(value="smsMappingMongoConverter")
    public MappingMongoConverter smsMappingMongoConverter(@Qualifier("smsMongoDbFactory") MongoDbFactory mongoDbFactory,
                                                       @Qualifier("smsCustomConversions") CustomConversions productCustomConversions) {
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
        converter.setCustomConversions(productCustomConversions);
        converter.afterPropertiesSet();
        return converter;
    }

}
