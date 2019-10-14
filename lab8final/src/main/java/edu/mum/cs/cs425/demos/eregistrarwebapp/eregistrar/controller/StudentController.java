package edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.controller;

import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.model.Student;
import edu.mum.cs.cs425.demos.eregistrarwebapp.eregistrar.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/eregistrar/student")
public class StudentController {
    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.displayAllStudent());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student());
    return "student/new";
    }

    @PostMapping (value = "/new")
    public String addNewStudent(@ModelAttribute("student") Student student, BindingResult bindingResult,Model model){
//        if (bindingResult.hasErrors()){
//            model.addAttribute("errors",bindingResult.getAllErrors());
//            return "student/new";
//        }
        studentService.registerNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }
    @GetMapping(value="/new/{studentId}")
    public String retrieveStudentTOBeUpdated(@PathVariable int studentId, Model model){
        Student student=studentService.findById(studentId);
        if(student!=null){
            model.addAttribute("student",student);
            return "student/new";
        }
        return "student/list";
    }
    @GetMapping(value = {"/eregistrar/student/delete/{studentId}"})
    public String deleteBook(@PathVariable Integer studentId, Model model) {
        Student student = studentService.findById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            studentService.deleteStudentById(studentId);
        }
        return "redirect:/eregistrar/student/list";

    }}
