// HelloCheck 어노테이션이 붙어 있으면 hello를 출력하게 만들고 싶다

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 유지되는 기간
@Retention(RetentionPolicy.RUNTIME)
// 어노테이션이 붙을 수 있는 위치
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface HelloCheck {
    // 어노테이션은 필드가 하나면 value라고 보통 사용한다
    String value();
}
