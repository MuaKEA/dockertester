package com.kea.dk.demo.Controller.Auth;//package com.manda2.demo.Controller;
//
//import com.manda2.demo.session.Auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpSession;
//
//@SessionAttributes("session")
//@Controller
//public class LoginController {
//
//    @Autowired
//    Auth auth;
//
//    @GetMapping("login")
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(String email, String password, HttpSession httpSession) throws SQLException {
//        System.out.println(email);
//        System.out.println(password);
//
//        if (auth.login(email, password, httpSession)) {
//            System.out.println("login in");
//        }
//
//        return "login";
//    }
//}
