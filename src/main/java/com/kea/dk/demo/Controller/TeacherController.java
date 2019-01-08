package com.kea.dk.demo.Controller;


import com.kea.dk.demo.Model.Course;
import com.kea.dk.demo.Model.Login;
import com.kea.dk.demo.Repos.CourseRepository;
import com.kea.dk.demo.Repos.StuRepository;
import com.kea.dk.demo.Repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TeacherController {
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public StuRepository studrepo;
    @Autowired
    public TeacherRepo teacherRepo;


    @GetMapping("/teacherMenu{email}")
    public String adminMenu(@RequestParam(value = "email") String username) {
        return "teacherMenu";
    }


    @GetMapping("/teacher/")
    public String chefPage(HttpSession session) {
        if (Login.isLoggedIn(session) && Login.isTeacher(session))
            return "/chef/index";
        else
            return "redirect:/";
    }


    //Fix id
    @GetMapping("/createcourse")
    public String Createcourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("teacherList", teacherRepo.findAll());

        return "save_course";
    }

    @PostMapping("/createcourse")
    public String Createcourse(Course course) {

        courseRepository.save(course);

        return "redirect:/ShowCourses";
    }


    @GetMapping("/ShowCourses")
    public String showCourse(Model model) {
        model.addAttribute("studentList", courseRepository.findAll());
        return "ShowCourses";
    }


    @GetMapping("/deletecourse")
    public String delete(@RequestParam(value = "id", defaultValue = "1") Long id) {
        courseRepository.deleteById(id);

        return "redirect:/ShowCourses";
    }

    @GetMapping("/editcourse")
    public String editcourse(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id));
        return "editCourses";
    }

    @PostMapping("/editcourse")
    public String editcourse(Course course) {
        courseRepository.save(course);
        courseRepository.deleteById(course.getId());

        return "redirect:/ShowCourses";
    }


}










