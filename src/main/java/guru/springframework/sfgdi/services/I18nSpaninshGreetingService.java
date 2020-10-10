package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("SP")
@Service("i18nService")
public class I18nSpaninshGreetingService implements GreetingService{
  @Override public String sayGreeting() {
    return "Hola Mundo - ES";
  }
}