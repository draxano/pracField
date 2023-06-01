package com.draxano.demo.courses;

import com.draxano.demo.user.CourseRepository;
import com.draxano.demo.user.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor // is this going to be the solution.
public class CoursesController {


    private final CourseRepository courseRepository; // the problem was here. We forgot the final

    @GetMapping("/all")
    public List<Courses> viewAll(){
        return courseRepository.findAll();  // Since there isn't much business logic I didn't create a service for this.
    }


    // Doesn't work
    @PostMapping("/add")
    public ResponseEntity<String> newCourse(@RequestBody Courses courses){
         courseRepository.save(courses);
         return ResponseEntity.ok("Course has been added!");
    } // problem might be here

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        courseRepository.deleteById(id);
        return new ResponseEntity<>("The course has been deleted", HttpStatus.OK);
    }


    // Works
    @GetMapping("/hello")
    public ResponseEntity<String> helloCont() {
        return ResponseEntity.ok("Check");
    }
}
