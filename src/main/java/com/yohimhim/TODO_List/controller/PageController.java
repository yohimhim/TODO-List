package com.yohimhim.TODO_List.controller;

import com.yohimhim.TODO_List.model.Task;
import com.yohimhim.TODO_List.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
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

    @GetMapping("/addTask") //post
    public String addTask() {

        //taskService.addOrUpdateTask(task);

        return "addTask";
    }

    public String updateTask() {

        //taskService.addOrUpdateTask();
        return "update";

    }

}
