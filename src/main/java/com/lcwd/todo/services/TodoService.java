package com.lcwd.todo.services;

import com.lcwd.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    List<Todo> todos = new ArrayList<>();
    //create todo method
    public Todo createTodo(Todo todo)
    {
        //create
        //change the logic
        todos.add(todo);
        logger.info("Todos {}",this.todos);
        return todo;
    }

    public List<Todo> getAllTodos()
    {
        return todos;
    }

    public Todo getTotobyID( int id)
    {
        Todo todo=todos.stream().filter(t -> id == t.getId()).findAny().get();
        logger.info("Todo : {}", todo);
        return todo;
    }

    public Todo updateTodo(int todoId, Todo newTodo)
    {
        List<Todo> newUpdateList= todos.stream().map(t -> {
            if(t.getId()==todoId)
            {
                //perform update
                t.setTitle(newTodo.getTitle());
                t.setContent(newTodo.getContent());
                t.setStatus(newTodo.getStatus());
                return  t;
            }
            else
            {
                return t;
            }
        }).collect(Collectors.toList());

        todos=newUpdateList;
        newTodo.setId(todoId);
        return newTodo;

    }


    public void deleteTodo(int todoId)
    {
        List<Todo> newList= todos.stream().filter(t-> t.getId() != todoId).collect(Collectors.toList());
        todos=newList;
    }
}
