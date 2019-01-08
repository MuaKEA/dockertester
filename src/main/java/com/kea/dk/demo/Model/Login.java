package com.kea.dk.demo.Model;


import com.kea.dk.demo.Repos.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class Login {

    private static LoginTable loginTable;
    @Autowired
    private static loginRepository LoginRepository;

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("ID") != null;
    }


    public static void logout(HttpSession session) {
        session.removeAttribute("ID");
        session.removeAttribute("NIVEAU");

    }


    public static boolean isTeacher(HttpSession session) {
        return (int) session.getAttribute("NIVEAU") == 1;

    }

    public static boolean isStudent(HttpSession session) {
        return (int) session.getAttribute("NIVEAU") == 2;

    }

    public static boolean isadministrator(HttpSession session) {
        return (int) session.getAttribute("NIVEAU") == 3;
    }
}

