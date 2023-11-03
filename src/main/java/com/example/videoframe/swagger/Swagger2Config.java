//package com.example.videoframe.swagger;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//
//
//@Configuration
//@EnableOpenApi //开启swagger功能
////@EnableKnife4j
//@Slf4j
////@EnableWebMvc
////@EnableSwaggerBootstrapUI
////@Profile({"dev", "local"})
//public class Swagger2Config {
//
//    /**
//     * 是否开启swagger配置，生产环境需关闭
//     */
//    /*    @Value("${swagger.enabled}")*/
//    private boolean enable;
//
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.OAS_30)
////                .apiInfo(apiInfo())
////                .enable(true)
////                .groupName("文章操作")
//                .select()
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.basePackage("com.example.videoframe"))
////                .paths(PathSelectors.any())
//                .build();
//    }
//
////    @Bean
////    public Docket createArticleManageApi() {
////        return new Docket(DocumentationType.OAS_30).pathMapping("/")
////                /*.enable(enable)*/
////                .groupName("文章操作")
////                .select()
////                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
////
//////                .apis(RequestHandlerSelectors.basePackage("com.example.videoframe"))
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(apiInfo())
////                // 支持的通讯协议集合
////                .protocols(newHashSet("https", "http"))
////                .securitySchemes(securitySchemes())
////                .securityContexts(securityContexts());
////    }
//
//
////    @SuppressWarnings("all")
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("文章操作")
//                .description("swagger Restful API文档")
//                .version("1.0.0").build();
//    }
//
//    /**
//     * 支持的通讯协议集合
//     *
//     * @param type1
//     * @param type2
//     * @return
//     */
//    private Set<String> newHashSet(String type1, String type2) {
//        Set<String> set = new HashSet<>();
//        set.add(type1);
//        set.add(type2);
//        return set;
//    }
//
//    /**
//     * 认证的安全上下文
//     */
//    private List<SecurityScheme> securitySchemes() {
//        List<SecurityScheme> securitySchemes = new ArrayList<>();
//        securitySchemes.add(new ApiKey("token", "token", "header"));
//        return securitySchemes;
//    }
//
//    /**
//     * 授权信息全局应用
//     */
//    private List<SecurityContext> securityContexts() {
//        List<SecurityContext> securityContexts = new ArrayList<>();
//        securityContexts.add(SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.any()).build());
//        return securityContexts;
//    }
//
//    /**
//     * 默认的安全上引用
//     */
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        List<SecurityReference> securityReferences = new ArrayList<>();
//        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
//        return securityReferences;
//    }
//
//}
