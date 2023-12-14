package com.example.TODOLIST;
/*
- 파일명: ToDolist 만들기
- 클래스명: Class TodoController
- 프로그램 목적 및 기능: html에 값을 받아오고 실행하도록 설계 하였다.
- 프로그램 작성자: 김나은, 박형건
====================================================================================
- 프로그램 작성일: 2023.12.10
- 프로그램 최종 수정일: 2023.12.13
====================================================================================
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller//주석은 이 클래스를 Spring MVC 컨트롤러로 표시하여 웹 요청을 처리할 것임을 나타냅니다.
public class TodoController {

    @Autowired
    // 인스턴스를 컨트롤러에 주입합니다. 이를 통해 컨트롤러는 데이터베이스와 상호 작용하여 투두 엔터티에 대한 CRUD(생성, 읽기, 업데이트, 삭제) 작업을 수행할 수 있습니다.
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    //이 메소드는 "/todos"에 대한 HTTP GET 요청을 처리합니다
    public String getAllTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        //데이터베이스에서 모든 투두 객체를 검색합니다. "todos" 키를 사용하여 모델에 할일 목록을 추가합니다. 렌더링할 Thymeleaf 템플릿(HTML 파일)의 이름인 "index2"를 반환합니다.
        return "index2"; // index2.html 파일 경로
    }

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo) { // @ModelAttribute 사용
        todoRepository.save(todo);
        return "redirect:/todos"; // 목록 페이지로 리다이렉트
    }

    @PutMapping("/todos/{id}")
    //"/todos"에 대한 HTTP POST 요청을 처리합니다.
    public String updateTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoRepository.findById(id).orElse(null);
        model.addAttribute("todo", todo);
        //요청에 제공된 데이터를 사용하여 새로운 'Todo객체를 생성합니다. 그런 다음 할 일을 저장소에 저장하고 "/todos"로 리디렉션합니다. 끝점.
        return "index3"; // Create a new Thymeleaf template for update form (update-form.html)
    }

    @PostMapping("/todos/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo updatedTodo) {
        Todo todo = todoRepository.findById(id).orElse(null);

        if (todo != null) {
            todo.setTitle(updatedTodo.getTitle());
            todo.setMessage(updatedTodo.getMessage());
            todo.setCompleted(updatedTodo.isCompleted());
            todoRepository.save(todo);
        }

        return "redirect:/todos";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

}
