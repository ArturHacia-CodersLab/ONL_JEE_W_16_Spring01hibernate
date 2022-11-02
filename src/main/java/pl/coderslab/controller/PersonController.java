package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("person", new Person());
        return "/person/form";
    }

//    @PostMapping("/form")
//    @ResponseBody
//    public String saveForm(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personService.savePerson(person);
//        return "dodano " + person;
//    }

    @PostMapping("/form")
    @ResponseBody
    public String saveForm(Person person) {
        personService.savePerson(person);
        return "dodano " + person;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login ) {
        Person person = personService.findById(id);
        person.setLogin(login);
        personService.update(person);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        personService.delete(id);
        return "deleted";
    }
}
