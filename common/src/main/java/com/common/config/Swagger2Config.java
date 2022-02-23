package com.common.config;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.comparator.PinyinComparator;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.google.common.base.Optional;
import com.google.common.collect.Ordering;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiListingReference;
import springfox.documentation.service.Operation;
import springfox.documentation.service.Tag;
import springfox.documentation.service.Tags;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 通过@Configuration注解，让Spring来加载该类配置。再通过@EnableSwagger2注解来启用Swagger2。
 * 再通过createRestApi函数创建Docket的Bean之后， apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
 * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API， 并产生文档内容（除了被@ApiIgnore指定的请求）。
 * <p>
 * 添加文档内容
 * <p>
 * 在完成了上述配置后，其实已经可以生产文档内容，但是这样的文档主要针对请求本身，
 * 而描述主要来源于函数等命名产生，对用户并不友好，我们通常需要自己增加一些说明来丰富文档内容。
 * 如:我们通过@ApiOperation注解来给API增加说明、
 * 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
 */
@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config
{
    /**
     * Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。
     * 总体目标是使客户端和文件系统作为服务器以同样的速度来更新。
     * 文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。
     * Swagger 让部署管理和使用功能强大的API从未如此简单。
     */
    @Bean
    public Docket createRestApi()
    {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
        /**
         * tag排序 {@link Tags#thenByName()}
         * 类内部，方法排序  apiDescriptionOrdering
         */
        docket.apiDescriptionOrdering(new Ordering<ApiDescription>()
        {

            @Override
            public int compare(@Nullable ApiDescription left, @Nullable ApiDescription right)
            {
                return getKey(right).compareTo(getKey(left));
            }
        });
        ApiSelectorBuilder selectorBuilder = docket.select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).apis(input -> {
                    //自定义过滤策略
                    Class<?> aClass = input.declaringClass();
                    Api annotation = AnnotationUtil.getAnnotation(aClass, Api.class);
                    ApiOperation apiOperation = input.findAnnotation(ApiOperation.class).orNull();
                    log.info("Api:" + annotation);
                    log.info("ApiOperation:" + apiOperation);
                    if (apiOperation != null)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }).apis(RequestHandlerSelectors.basePackage("com.common")).paths(PathSelectors.any());
        selectorBuilder.build();
        /**
         * 通过反射 进行tags排序
         */
        //docket.tags()
        Set<Tag> tags = (Set<Tag>) ReflectUtil.getFieldValue(docket, "tags");
        return docket;
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").version("2.0.0").build();
    }

    /**
     * 获取API的描述KEY，用来排序
     *
     * @param model
     * @return
     */
    private String getKey(ApiDescription model)
    {
        String keyStr = "";
        List<Operation> operations = model.getOperations();
        if (operations != null)
        {
            Operation operation = operations.get(0);
            Set<String> tags = operation.getTags();
            if (tags != null)
            {
                keyStr = CollUtil.join(tags, ",");
            }
            String summary = operation.getSummary();
            if (!StrUtil.isEmpty(summary))
            {
                keyStr = keyStr + summary;
            }
        }
        keyStr = PinyinUtil.getFirstLetter(keyStr, "");
        return keyStr;
    }
}
