package com.raphmei.taskapi.controller;

import com.raphmei.taskapi.model.Task;
import com.raphmei.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Récupérer toutes les tâches
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Récupérer une tâche par ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Créer une nouvelle tâche
    @PostMapping("/tasks/add")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Mettre à jour une tâche
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    // Supprimer une tâche
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


// Endpoint pour marquer une tâche comme terminée
    @GetMapping("/tasks/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        Task task = taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus("Terminé");
        taskService.updateTask(id, task);
        return "redirect:/";
    }

}
