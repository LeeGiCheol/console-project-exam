package me.gicheol.view;

import me.gicheol.dao.UsersDao;
import me.gicheol.domain.Users;
import me.gicheol.main.Main;
import me.gicheol.service.UsersService;


public class MainView {


    public void mainView() {
        RegistView registView = new RegistView();
        CommunityView communityView = new CommunityView();

        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|           유저관리 프로그램           |");
        System.out.println("|                                  |");
        System.out.println("|           1. 회원가입              |");
        System.out.println("|           2. 로그인                |");
        System.out.println("|                                  |");
        System.out.println("|            v0.1                  |");
        System.out.println("|            by GICHEOL            |");
        System.out.println("|                                  |");
        System.out.println("====================================");

        switch (Main.sc.nextInt()) {
            case 1:
                registView.signUp();
                mainView();
                break;
            case 2:
                Users user = registView.login();
                communityView.community(user);
                break;
            default:
                System.out.println("다시 입력해주세요.");
        }
    }

}
