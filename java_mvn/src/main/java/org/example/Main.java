package org.example;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("홍길동");
        System.out.println(user);

        User user2 = User.builder()
                .idx(1)
                .name("임꺽정")
                .build();
        //= User user1 = new User(idx:1,name:"임꺽정");
        System.out.println(user2);
    }
}