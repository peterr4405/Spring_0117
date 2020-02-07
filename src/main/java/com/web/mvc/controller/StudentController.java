package com.web.mvc.controller;

import com.web.beans.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

   public  static List<Student> students = new ArrayList<>();

    @RequestMapping("/input")
    public String input(Model model) {

        Student s = new Student();
        model.addAttribute("students", students);
        model.addAttribute("action", "add");
        model.addAttribute("student", s);
        return "student";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute Student s) {
        int id = 1;
        if (students.size() != 0) {
            id = students.stream().mapToInt(n -> n.getId()).max().getAsInt() + 1;
        }
        s.setId(id);
        students.add(s);
        System.out.println(students);

        return "redirect:./input";
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        Student student = students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        model.addAttribute("students", students);
        model.addAttribute("action", "update");
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute Student s, Model model) {
        int id = s.getId();
        Student student = students.stream().filter(u -> u.getId().equals(id)).findFirst().get();
        model.addAttribute("students", students);
        model.addAttribute("action", "update");
        student.setName(s.getName());
        student.setAge(s.getAge());
        return "redirect:./input";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Student student = students.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        students.remove(student);

        return "redirect:../input";
    }
}
