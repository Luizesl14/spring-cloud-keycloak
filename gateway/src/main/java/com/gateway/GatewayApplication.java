package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes (RouteLocatorBuilder builder){
        return builder
                .routes()
                    .route("adm", r-> r.path("/adm/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://admin-server/"))

                    .route("eureka" ,r-> r.path("/eureka/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://discovery-server"))

                    .route("crm", r-> r.path("/crm/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://crm-module"))

                    .route("credit", r-> r.path("/credit/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://credit-module"))

                    .route("k_adm", r-> r.path("/k_adm/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://keycloak-module"))

                    .route("reg", r-> r.path("/reg/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://register-module"))

                    .route("risk", r-> r.path("/risk/**")
                            .filters(f-> f.stripPrefix(1))
                            .uri("lb://risk-module"))
                .build();
    }
}
