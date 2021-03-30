package hello.hellospring.service;

import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
/*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {

        this.dataSource = dataSource;
    }
*/
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean //스프링빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository()); // MemberService를 불러와서 스프링빈에 등록
    }

    @Bean
    public MemberRepository memberRepository() {

       // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
      //  return new JdbcTempleateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
    // MemberService랑 memberRepository 둘 다 스프링빈에 등록
    // MemberService에  private final MemberRepository memberRepository; 에 memberRepository를 넣어줌.
}
