package com.example.grazie;

import org.springframework.stereotype.Service;

// 커피를 말아주는 직원
@Service
public class CoffeeService {
    public Coffee 아메리카노(){
        return new Coffee("아메리카노");
    }
    
    public Coffee 카푸치노(){
        return new Coffee("카푸치노");
    }

    public Coffee 아샷추(){
        return new Coffee("아샷추");
    }
}
