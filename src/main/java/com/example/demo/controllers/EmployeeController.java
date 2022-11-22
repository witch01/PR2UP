package com.example.demo.controllers;


import com.example.demo.models.Employee;
import com.example.demo.models.Post;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public String blogMain(Model model)
    {
        Iterable<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employee", employee);
        return "employee-main";
    }

    @GetMapping("/employee/add")
    public String EmployeeAdd(Model model)
    {
        return "employee-add";
    }

    @PostMapping("/employee/add")
    public String employeePostAdd(@RequestParam(defaultValue = "0") String surname,
                                  @RequestParam(defaultValue ="0") double salary,
                                  @RequestParam(defaultValue = "false") boolean gender,
                              @RequestParam(defaultValue = "0") int children,
                              @RequestParam(defaultValue = "2022.11.11") Date dr, Model model)
    {

        Employee employee = new Employee(surname, dr, gender, salary, children);
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/filter")
    public String employeeFilter(Model model)
    {
        return "employee-filter";
    }

    @PostMapping("/employee/filter/result")
    public String blogResult(@RequestParam String surname, Model model)
    {
        List<Employee> result = employeeRepository.findBySurnameContains(surname);
        List<Employee> result1 = employeeRepository.findBySurname(surname);
//        List<Post> result = postRepository.findLikeTitle(title);
        model.addAttribute("result", result);
        return "employee-filter";
    }
}
