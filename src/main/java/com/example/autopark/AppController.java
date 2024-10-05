package com.example.autopark;


import java.util.List; // Импортируем коллекцию (класс списков)

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
    private TheatreService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<TheatreORM> listPerf = service.listAll(keyword);
        model.addAttribute("listPerf", listPerf);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewBookForm(Model model) {
        TheatreORM perf = new TheatreORM();
        model.addAttribute("perf", perf);
        return "new_perf";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("perf") TheatreORM perf) {
        service.save(perf); // Сохраняем книгу
        return "redirect:/"; //
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAutoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_perf");
        TheatreORM perf = service.get(id);
        mav.addObject("perf", perf);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}