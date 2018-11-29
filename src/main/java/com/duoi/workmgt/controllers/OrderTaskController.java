package com.duoi.workmgt.controllers;

import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.respository.TaskRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/{menagerId}/{dayId}/order_task")
public class OrderTaskController {

    private TaskRepository repository;

    public OrderTaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Task> allTasks(){
        return repository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Task postOrderedTask(@RequestBody Task task){
        return repository.save(task);
    }

    @PutMapping(path = "/{orderTaskId}", consumes = "application/json")
    public Task putOrderedTask(@RequestBody Task task){
        return repository.save(task);
    }

    @PatchMapping(path = "/{orderTaskId}", consumes = "application/json")
    public Task patchOrderedTask(@PathVariable("taskId") Long taskId,@RequestBody Task patch){
        Task task = repository.findById(taskId).get();
        if(patch.getName() != null)
            task.setName(patch.getName());
        if(patch.getDay() != null)
            task.setDay(patch.getDay());
        //??
        if(patch.getManager() != null)
            task.setManager(patch.getManager());
        if(patch.getEmployees() != null)
            task.setEmployees(patch.getEmployees());
        //??
        if(patch.getDescription() != null)
            task.setDescription(patch.getDescription());
        if(patch.getBeginningOfTask() != null)
            task.setBeginningOfTask(patch.getBeginningOfTask());
        if(patch.getEndOfTask() != null)
            task.setEndOfTask(patch.getEndOfTask());

        return repository.save(task);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderedTask(@PathVariable("orderedTaskId") Long orderId){
        try{
            repository.deleteById(orderId);
        }catch (EmptyResultDataAccessException e){

        }
    }

}
