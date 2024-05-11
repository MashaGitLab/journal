package com.maria.journal.controllers;

import com.maria.journal.domain.entity.Student;
import com.maria.journal.domain.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name",required = false,defaultValue = "World") String name,Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model){
        Iterable<Student> students= studentRepo.findAll();
        model.addAttribute("students",students);
        return "main";

    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam int groupp,Model model){
        final  Student student=new Student(text, groupp);
        studentRepo.save(student);
        Iterable<Student> students= studentRepo.findAll();
        model.addAttribute("students",students);
        return "redirect:/";

    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter,Model model){
        Iterable<Student> students;
        if(filter!=null && !filter.isEmpty()){
            int flrt=Integer.parseInt(filter);
            students=studentRepo.findByGroupp(flrt);}
        else{
            students=studentRepo.findAll();
        }
        model.addAttribute("students",students);
        return "main";

    }

}