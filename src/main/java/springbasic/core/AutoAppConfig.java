package springbasic.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
Spring 에서는 따로 스캔할 패키지를 지정하지 않으면 @ComponentScan 의 시작점부터 하위 패키지를 모두 스캔하여 @Component 를 검색하지만
SpringBoot 에서는 기본 애플리케이션에 있는 @SpringBootApplication 에 @ComponentScan 이 포함되어 있기 때문에
루트 하위 패키지를 스캔하여 자동으로 스프링빈으로 등록된다.
 */
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //예제에 사용했던 AppConfig, TestConfig 를 제외하기 위해 사용
)
public class AutoAppConfig {

}
