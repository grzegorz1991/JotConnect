package pl.coderslab.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.note.Note;
import pl.coderslab.note.NoteService;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/createNote")
    public String showCreateNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "createNote";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveNote(note);
        return "redirect:/notes";
    }
}
