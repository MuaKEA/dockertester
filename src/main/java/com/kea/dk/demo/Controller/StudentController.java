package com.kea.dk.demo.Controller;


import com.kea.dk.demo.Model.Course;
import com.kea.dk.demo.Model.LoginTable;
import com.kea.dk.demo.Model.Student;
import com.kea.dk.demo.Model.WaitingList;
import com.kea.dk.demo.Repos.CourseRepository;
import com.kea.dk.demo.Repos.StuRepository;
import com.kea.dk.demo.Repos.WaitinglistRepo;
import com.kea.dk.demo.Repos.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    public Long Id;
    public String email;
    @Autowired
    private StuRepository stuRepo;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private WaitinglistRepo waitinglistRepo;
    @Autowired
    private com.kea.dk.demo.Repos.loginRepository loginRepository;


    @GetMapping("/dagensvejr")
    public String Dagensvejr(){


        return "dagensvejr";
    }


    @GetMapping("/studentMenu{id}")
    public String adminMenu(@RequestParam(value = "id") Long id) {

        Id = id;

        return "studentMenu";
    }

    @GetMapping("/createStudent")
    public String createstudent(Model model) {
        model.addAttribute("student", new Student());

        return "createStudent";
    }

    @PostMapping("/createStudent")
    public String createstudent(Student student) {
        stuRepo.save(student);
        Id = student.getId();
        LoginTable loginTable = new LoginTable(student.getEmail(), "password", 2);
        loginRepository.save(loginTable);
        return "redirect:/chooseCourse";

    }

    @GetMapping("chooseCourse")
    public String choosecourse(Model model) {
        model.addAttribute("courseList", courseRepository.findAll());
        return "chooseCourse";
    }

    @PostMapping("choosecourse")
    public String choosecourse(@ModelAttribute WaitingList waitingList, @RequestParam(value = "courseids[]") Long[] courseList) {
        for (int i = 0; i < courseList.length; i++) {
            WaitingList w = new WaitingList();
            Student student = stuRepo.findById(Id).get();
            Course course = courseRepository.findById(courseList[i]).get();
            System.out.println("");
            w.setCourse(course);
            w.setStudent(student);
            w.setDate(w.getcurrentdate());
            w.setAssigned(false);
            waitinglistRepo.save(w);


        }
        return "redirect:/";
    }

    @GetMapping("/myCourses")
    public String myCourses(Model model) {
        model.addAttribute("studentList", waitinglistRepo.findByStudentIdAndAssigned(Id, true));

        return "myCourses";
    }

    @GetMapping("/studentList")
    public String studentList(Model model) {


        model.addAttribute("courseList", waitinglistRepo.findByAssigned(true));

        return "studentList";
    }
//    @GetMapping("/chooseNewcourses")
//    public String chooseNewcourses(Model model) {
//        List<WaitingList> student = waitinglistRepo.findAllByStudentId(Id);
//        List<Course> courses = courseRepository.findAll();
//        if (student.size() == 0) {
//            model.addAttribute("courseList", courseRepository.findAll());
//            return "chooseCourse";
//        } else
//            for (int i = 0; i < courses.size(); i++) {
//                for (int j = 0; j < student.size(); j++) {
//                    if (student.get(j).getCourse().getId().equals(courses.get(i).getId())) {
//                        courses.remove(i);
//                    }
//                }
//            }
//        model.addAttribute("courseList", courses);
//        return "chooseCourse";
//    }
}

