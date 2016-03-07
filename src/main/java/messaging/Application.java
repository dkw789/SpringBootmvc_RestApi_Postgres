package messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //equivalent to @Configuration, @EnableAutoConfiguration and @ComponentScan

//@EntityScan(basePackageClasses=Message.class)
public class Application {

//    @Bean
//    public Integer port() {
//        return SocketUtils.findAvailableTcpPort();
//    }
//
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(port());
//        return connector;
//    }
//


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
