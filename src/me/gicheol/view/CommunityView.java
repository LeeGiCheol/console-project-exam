package me.gicheol.view;


import me.gicheol.domain.Users;

public class CommunityView {

    public void community(Users user) {
        System.out.println("====================================");
        System.out.println("|                                  |");
        System.out.println("|             게시판입니다.            |");
        System.out.println("|                                  |");
        System.out.println("====================================\n");

        System.out.println(user.toString());
    }

}
