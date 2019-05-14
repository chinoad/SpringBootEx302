package springbootex302.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/")
    public String listTasks(Model model){
        model.addAttribute("todos", taskRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String todoForm(Model model){
        model.addAttribute("todo", new ToDo());
        return "todoForm";
    }

    @PostMapping("/process")
    public String processForm(@Valid ToDo todo, BindingResult result){
        if(result.hasErrors()){
            return "todoForm";
        }

        taskRepository.save(todo);
        return "redirect:/";
    }

}
