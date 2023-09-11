package com.example.HW13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteControllerNew {
    private final NoteService service;

    @GetMapping("/list")
    public ModelAndView getAllList() {
        ModelAndView result = new ModelAndView("noteList");
        result.addObject("note", service.listAll());
        return result;
    }
    @GetMapping("/create")
    public ModelAndView formNote() {
        ModelAndView result = new ModelAndView("create");
        result.addObject("note", new Note());
        return result;
    }
    @PostMapping("/create")
    public ModelAndView addNote(@ModelAttribute("note") Note note) {
        service.addNote(note);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("note", service.listAll());
        return result;
    }
    @PostMapping("/delete")
    public ModelAndView deleteById(Long id) {
        service.deleteById(id);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("note", service.listAll());
        return result;
    }
    @GetMapping("/edit")
    public ModelAndView updateById(@RequestParam(required = false) Long id) {
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", service.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView renameNote(@ModelAttribute("note") Note note) {
        note.setTitle(note.getTitle());
        note.setContent(note.getContent());
        service.update(note);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("note", service.listAll());
        return result;
    }
}

