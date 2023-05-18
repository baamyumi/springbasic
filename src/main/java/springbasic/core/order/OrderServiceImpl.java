package springbasic.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbasic.core.discount.DiscountPolicy;
import springbasic.core.member.Member;
import springbasic.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    /* 생성자 주입을 해야하는 이유2 : final 키워드를 사용할 수 있다. 생성자에서 값이 설정되지 않는 오류를 컴파일 시점에서 막아준다. 오류 발생 방지 */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
