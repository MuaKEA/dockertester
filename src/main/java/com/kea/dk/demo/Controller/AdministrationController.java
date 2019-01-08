package com.kea.dk.demo.Controller;


import com.kea.dk.demo.Model.LoginTable;
import com.kea.dk.demo.Model.Teacher;
import com.kea.dk.demo.Model.WaitingList;
import com.kea.dk.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministrationController {
    @Autowired
    public StuRepository studentRepo;
    @Autowired
    public CourseRepository courseRepo;
    @Autowired
    public WaitinglistRepo waitinglistRepo;
    @Autowired
    public TeacherRepo teacherRepo;
    @Autowired
    public com.kea.dk.demo.Repos.loginRepository loginRepository;


    @GetMapping("/adminMenu")
    public String adminMenu() {
        return "adminMenu";
    }


    @GetMapping("/createTeacher")
    public String createTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());


        return "CreateTeachers";
    }

    @PostMapping("/createTeacher")
    public String createTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
        LoginTable loginTable = new LoginTable(teacher.getEmail(), "password", 1);
        loginRepository.save(loginTable);


        return "redirect:/adminMenu";


    }

    @GetMapping("/RejectOrAccept")
    public String accepORrejectstudent(Model model) {
        model.addAttribute("studentandcourses", waitinglistRepo.findByAssigned(false));


        return "RejectOrAccept";
    }


    @GetMapping("/rejectStudent/{id}/{courseid}")
    public String rejectStudent(@PathVariable(value = "id") Long id, @PathVariable(value = "courseid") Long courseid) {
        WaitingList w = waitinglistRepo.findByStudentIdAndCourseId(id, courseid);
        waitinglistRepo.deleteById(w.getId());

        return "redirect:/RejectOrAccept";
    }

    @GetMapping("/AccepedStudent/{id}/{courseid}")
    public String AccepedStudent(@PathVariable(value = "id") Long id, @PathVariable(value = "courseid") Long courseid) {
        WaitingList w = waitinglistRepo.findByStudentIdAndCourseId(id, courseid);
        w.setAssigned(true);
        waitinglistRepo.save(w);
        return "redirect:/RejectOrAccept";
    }


}
