package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /* 탐색패키지 시작 위치 지정. 아래처럼 지정해주지 않으면 모든 자바파일, 라이브러리까지 다 스캔하게 됨. 중괄호로 묶으면 여러개도 지정 가능
        지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨
        그래서 보통은 설정 정보 클래스의 위치를 프로젝트의 최상단에 둠
         */
        basePackages = "hello.core",
        // 예제용 class에서 사용한 @Configuration 설정 정보를 자동 scan 대상에서 제외하기 위함
        // 왜냐면 해당 어노테이션 내에 @Component 어노테이션이 들어있어서.....
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
