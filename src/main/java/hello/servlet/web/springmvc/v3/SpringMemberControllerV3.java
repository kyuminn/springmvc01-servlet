package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**v3-> return String (view의 논리적인 이름)
 * Annotation 기반 Spring Controller는 유연하게 설계되어 있음
 * ModelAndView를 반환하지 않고 view의 논리적인 이름만 반환해도 view가 rendering 된다!
 * 
 * 파라미터로 폼에서 전송한 값과 model 등등을 받아서 처리 가능
 *
 * 요청 가능한 method 구분 (get. post . ...)
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping(value="/new-form")
    public String newForm(){
        return "new-form";
    }

    @GetMapping()
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }

    // @RequestParam = GET 쿼리 파라미터, POST 폼 파라미터 두 방식 모두 지원
    @PostMapping(value = "/save")
    public String save(@RequestParam("username")String username, @RequestParam("age")int age, Model model){

        Member member = new Member(username,age);
        memberRepository.save(member);
        model.addAttribute("member",member);
        return "save-result";
    }

}
