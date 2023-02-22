package com.test.todo.controller;

import com.test.todo.controller.requestDto.TodoRequestDto;
import com.test.todo.domain.Member;
import com.test.todo.domain.Todo;
import com.test.todo.repository.MemberRepository;
import com.test.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;
    @GetMapping("/todolist/{id}")
    public String todolist(Model model , @PathVariable Long id){
           Optional<Member> member=memberRepository.findById(id);

            model.addAttribute("member",member);
            model.addAttribute("todo",new TodoRequestDto());
        return "todolist";
    }

    @PostMapping("/todolist/{id}")
    public String todoSubmit(@ModelAttribute TodoRequestDto todo , @PathVariable Long id){
       Todo todo1 =Todo.builder()
               .member(memberRepository.findById(id).get())
                .content(todo.getContent())
                .build();
        todoRepository.save(todo1);
        return "redirect:"+id;
    }

}
