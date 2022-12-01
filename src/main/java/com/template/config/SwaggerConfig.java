package com.template.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    /*引入Knife4j提供的扩展类*/
    @Resource
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "test")
    public Docket test() {
        String groupName = "测试模块";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.template.controller.test"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(setHeader())
                //赋予插件体系
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }

    private List setHeader() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("认证token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return pars;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Kitty API Doc")
                .description("This is a restful api document of Kitty.")
                .version("1.0")
                .build();
    }

}
