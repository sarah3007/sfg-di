package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources({
//    @PropertySource("classpath:datasource.properties"),
//    @PropertySource("classpath:jms.properties"),
//})
public class PropertyConfig {
  @Value("${guru.user}")
  String user;
  @Value("${guru.password}")
  String password;
  @Value("${guru.url}")
  String url;

  @Value("${guru.jms.user}")
  String jmsUser;
  @Value("${guru.jms.password}")
  String jmsPassword;
  @Value("${guru.jms.url}")
  String jmsUrl;

  //@Autowired Environment env;

  @Bean
  public FakeDataSource fakeDataSource() {
    FakeDataSource fakeDataSource = new FakeDataSource();
    //fakeDataSource.setUser(env.getProperty("user"));
    fakeDataSource.setUser(user);
    fakeDataSource.setPassword(password);
    fakeDataSource.setUrl(url);
    return fakeDataSource;
  }

  @Bean
  public FakeJmsBroker fakeJmsBroker() {
    FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
    fakeJmsBroker.setUser(jmsUser);
    fakeJmsBroker.setPassword(jmsPassword);
    fakeJmsBroker.setUrl(jmsUrl);
    return fakeJmsBroker;
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    return propertySourcesPlaceholderConfigurer;
  }
}