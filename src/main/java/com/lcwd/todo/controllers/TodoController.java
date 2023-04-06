package com.lcwd.todo.controllers;

import com.lcwd.todo.models.Todo;
import com.lcwd.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;

    Random random = new Random();

    //create
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo)
    {
        //create todo
        int ids = random.nextInt(999999);
        todo.setId(ids);
        // create date with system default
        Date date = new Date();
        logger.info("current date : {}", date);
        todo.setAddedDate(date);
        logger.info("toadded {} ",todo.getAddedDate());
        logger.info("toDoDate {} ",todo.getToDoDate());
        //logger.info("todo {}",todo);
        logger.info("Create Todo");
        // call service to create todo
        Todo todo1 =todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
//        return todoService.createTodo(todo);
    }

    //get all todos
    @GetMapping()
    public ResponseEntity<List<Todo>> getAllTodoHandlers()
    {
            List<Todo> list= todoService.getAllTodos();
            return new ResponseEntity<List<Todo>>(list,HttpStatus.OK);
    }

    //get single todo
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable(name ="id") int id)
    {
        Todo item = todoService.getTotobyID(id);
        //return new ResponseEntity<>(item,HttpStatus.FOUND);
        return ResponseEntity.ok(item);
    }

    //update todo
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo newTodo,@PathVariable int todoId)
    {
           Todo todo= todoService.updateTodo(todoId , newTodo);
           return ResponseEntity.ok(todo);
    }

    //delete
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId)
    {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo successfully deleted !");
    }
}
