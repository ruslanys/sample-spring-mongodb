package ru.habrahabr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.habrahabr.services.ContactService;
import ru.habrahabr.model.Contact;

/**
 * Date: 26.03.2014
 * Time: 20:30
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Controller
public class MainController {
    @Autowired private ContactService contactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("contacts", contactService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("add_form", "contact", new Contact());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact) {
        if(contact.getId() == null) contactService.add(contact);
        else contactService.update(contact);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) Long id) {
        return new ModelAndView("add_form", "contact", contactService.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(required = true) Long id) {
        contactService.remove(id);

        return "redirect:/";
    }
}
