package com.yohimhim.TODO_List.controller;

import com.yohimhim.TODO_List.model.Task;
import com.yohimhim.TODO_List.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home(Model model) {
        List<Task> tasks = taskService.getAllTasks(); // should return List<Task>
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @RequestMapping("/addTask") //post
    public String addTask() {
        //taskService.addOrUpdateTask(task);
        return "addTask";
    }

    @RequestMapping("/submitTask") //post
    public String submitTask(HttpServletRequest req) {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String rawDeadline = req.getParameter("deadline");
        LocalDate deadline = LocalDate.parse(rawDeadline);
        Date utilDate = java.sql.Date.valueOf(deadline);

        taskService.addOrUpdateTask(title, description, utilDate);

        return "redirect:/";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @RequestMapping("/editTask")
    public String editTask(@RequestParam("id") int id) {

        taskService.editTask(id);
        return "update";

    }

}
