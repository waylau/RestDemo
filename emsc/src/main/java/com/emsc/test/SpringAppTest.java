package com.emsc.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
/**
 * @author waylau.com
 * 2014年12月29日
 */
@Configuration
@ComponentScan
public class SpringAppTest {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(SpringAppTest.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}