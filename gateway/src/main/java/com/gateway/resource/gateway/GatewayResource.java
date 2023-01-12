package com.gateway.resource.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class GatewayResource {

    @Autowired
    private TokenRelayGatewayFilterFactory filterFactory;

    @Bean
    public RouteLocator routes (RouteLocatorBuilder builder){
        return builder
                .routes()
                .route("adm", r-> r.path("/adm/**")
                        .filters(f-> f.stripPrefix(1))
                        .uri("lb://admin-server/"))

                .route("crm", r-> r.path("/crm/**")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie"))
                        .uri("lb://crm-module"))

                .route("credit", r-> r.path("/credit/**")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie"))
                        .uri("lb://credit-module"))

                .route("k_adm", r-> r.path("/k_adm/**")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie"))
                        .uri("lb://keycloak-module"))

                .route("reg", r-> r.path("/reg/**")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie"))
                        .uri("lb://register-module"))

                .route("risk", r-> r.path("/risk/**")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie"))
                        .uri("lb://risk-module"))
                .build();
    }
}
