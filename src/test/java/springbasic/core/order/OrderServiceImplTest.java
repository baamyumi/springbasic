package springbasic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springbasic.core.discount.FixDiscountPolicy;
import springbasic.core.member.Grade;
import springbasic.core.member.Member;
import springbasic.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        /* 생성자 주입을 해야하는 이유1 :어떤 값을 필수로 주입해야하는 지 바로 확인이 가능하다. */
        //OrderServiceImpl orderService = new OrderServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}