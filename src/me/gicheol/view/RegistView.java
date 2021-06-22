package me.gicheol.view;

import me.gicheol.domain.Users;
import me.gicheol.main.Main;
import me.gicheol.service.UsersService;

public class RegistView {

    UsersService usersService = new UsersService();

    public void signUp() {
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|         회원가입 페이지입니다.         |");
        System.out.println("|                                  |");
        System.out.println("====================================\n");

        Users user = new Users();

        System.out.print("이메일을 입력하세요 : ");
        user.setEmail(Main.sc.next());
        System.out.println();

        System.out.print("이름을 입력하세요 : ");
        user.setUsername(Main.sc.next());
        System.out.println();

        System.out.print("비밀번호를 입력하세요 : ");
        user.setPassword(Main.sc.next());
        System.out.println();

        usersService.signUpUser(user);
    }


    public Users login() {
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|          로그인 페이지입니다.         |");
        System.out.println("|                                  |");
        System.out.println("====================================\n");

        Users user = new Users();

        System.out.print("이메일을 입력하세요 : ");
        user.setEmail(Main.sc.next());
        System.out.println();

        System.out.print("비밀번호를 입력하세요 : ");
        user.setPassword(Main.sc.next());
        System.out.println();

        Users loginUser = usersService.login(user);

        if (loginUser != null) {
            return loginUser;
        } else {
            login();
        }

        return null;
    }
}
