package com.raphmei.taskapi.controller;


import com.raphmei.taskapi.model.Task;
import com.raphmei.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskViewController {

    @Autowired
    private TaskService taskService;

    // Afficher la liste des tâches
    @GetMapping("/")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks"; // Renvoie à la vue tasks.html
    }

    // Afficher le formulaire pour ajouter une nouvelle tâche
    @GetMapping("/tasks/new")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "new_task"; // Renvoie à la vue new_task.html
    }

    // Ajouter une nouvelle tâche
    @PostMapping("/tasks")
    public String addTask(@ModelAttribute("task") Task task) {
        taskService.createTask(task);
        return "redirect:/"; // Redirige vers la liste des tâches
    }

    // Supprimer une tâche
    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/"; // Redirige vers la liste des tâches
    }
}