package com.kea.dk.demo.ApiController;



import com.kea.dk.demo.Model.Student;
import com.kea.dk.demo.Repos.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unchecked")
@RestController
public class StudentRest {

    @Autowired
    private StuRepository stuRepository;





@GetMapping("student/{id}")
public ResponseEntity<Student> getstudents(@PathVariable Long id) {

    return new ResponseEntity(stuRepository.findById(id), HttpStatus.OK);

}
@PutMapping("student/update/{id}")
public ResponseEntity<Student> updatestudent(@PathVariable Long id, @RequestParam String firstName
                                             , @RequestParam String lastName, @RequestParam String address,
                                             @RequestParam int postcode, @RequestParam String city
                                            , @RequestParam String email, @RequestParam Long phone){


    Student student= new Student(firstName,lastName,address,postcode,city,email,phone);
    student.setId(id);
    stuRepository.save(student);



    return new ResponseEntity(student, HttpStatus.OK);
}
    @DeleteMapping("student/delete/{id}")
    public ResponseEntity<Student> delemapping(@PathVariable Long id) {


     stuRepository.deleteById(id);
        return new ResponseEntity("OK", HttpStatus.ACCEPTED);

    }

    @PostMapping("student/new")
    public ResponseEntity<Student> saveCar(Student student){


         stuRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

}
