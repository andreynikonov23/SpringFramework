package nick.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nick.pack.dao.PersonDAO;
import nick.pack.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.findAll());
        return "all";
    }

    
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.findById(id));
        return "person";
    }
    @GetMapping("/new")
    public String addForm(@ModelAttribute("person") Person person) {	
    	return "add";
    }
    @PostMapping()
    public String addPerson(@ModelAttribute("person") Person person) {
    	personDAO.add(person);
    	return "redirect:/people";
    }
    @GetMapping("{id}/edit")
    public String editFrom(@PathVariable("id") int id, Model model) {
    	model.addAttribute("person", personDAO.findById(id));
    	return "edit";
    }
    @PatchMapping()
    public String editPerson(@ModelAttribute("person") Person person) {
    	personDAO.update(person);
    	return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}