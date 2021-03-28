package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean //스프링빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository()); // MemberService를 불러와서 스프링빈에 등록
    }

    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    // MemberService랑 memberRepository 둘 다 스프링빈에 등록
    // MemberService에  private final MemberRepository memberRepository; 에 memberRepository를 넣어줌.
}
