package com.example.autopark;


import java.util.List; // Импортируем коллекцию (класс списков)

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private AutoService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<AutoORM> listBooks = service.listAll(keyword);
        model.addAttribute("listAuto", listBooks);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewBookForm(Model model) {
        AutoORM auto = new AutoORM();
        model.addAttribute("auto", auto);
        return "new_auto";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("auto") AutoORM auto) {
        service.save(auto); // Сохраняем книгу
        return "redirect:/"; //
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAutoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_auto");
        AutoORM auto = service.get(id);
        mav.addObject("auto", auto);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}