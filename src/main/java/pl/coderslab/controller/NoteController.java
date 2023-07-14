package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Catalog;
import pl.coderslab.service.CatalogService;
import pl.coderslab.service.NoteService;
import pl.coderslab.entity.Note;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/createNote")
    public String showNoteForm(Model model) {
        List<Catalog> catalogs = catalogService.getAllCatalogs(); // Replace with your CatalogService method to fetch catalogs
        model.addAttribute("note", new Note());
        model.addAttribute("catalogs", catalogs);
        return "createNote";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note) {
        System.out.println(note.getVisibility() + "Nołt wizibility");
        if ("visible".equals(note.getVisibility())) {
            note.setVisibility(true);
        } else {
            note.setVisibility(false);
        }
        noteService.saveNote(note);
        return "redirect:/";
    }
}
