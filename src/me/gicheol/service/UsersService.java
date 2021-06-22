package me.gicheol.service;

import me.gicheol.dao.UsersDao;
import me.gicheol.domain.Users;

public class UsersService {

    UsersDao usersDao = new UsersDao();

    public void signUpUser(Users user) {
        try {
            int successFlag = usersDao.signUp(user);

            if (successFlag == 1) {
                System.out.println(user.getUsername() + " 님 회원가입 완료되었습니다.");
            } else {
                System.out.println("회원가입 실패했습니다. 다시 시도해주세요.");
            }
        } catch (Exception e) {
            System.out.println("회원가입 실패했습니다. 다시 시도해주세요.");
        }
    }

    public Users login(Users user) {
        try {
            Users findUser = usersDao.get(user.getEmail());

            if (findUser.getPassword().equals(user.getPassword())) {
                System.out.println(findUser.getUsername() + "님 로그인 성공했습니다.");
                return user;
            } else {
                System.out.println("다시 시도해주세요.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("다시 시도해주세요.");
            return null;
        }

    }
}
