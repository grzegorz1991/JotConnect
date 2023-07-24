package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.directory.Directory;
import pl.coderslab.directory.DirectoryService;
import pl.coderslab.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping("/directories")
public class DirectoryController {

    @Autowired
    private final DirectoryService directoryService;


    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping
    public ResponseEntity<List<Directory>> getAllDirectories() {
        List<Directory> directories = directoryService.getAllDirectories();
        return ResponseEntity.ok(directories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Directory> getDirectoryById(@PathVariable Long id) {
        Directory directory = directoryService.getDirectoryById(id);
        if (directory != null) {
            return ResponseEntity.ok(directory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestBody Directory directory) {
        Directory savedDirectory = directoryService.saveDirectory(directory);
        return ResponseEntity.ok(savedDirectory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Directory> updateDirectory(@PathVariable Long id, @RequestBody Directory directory) {
        Directory existingDirectory = directoryService.getDirectoryById(id);
        if (existingDirectory != null) {
            directory.setId(id);
            Directory updatedDirectory = directoryService.updateDirectory(directory);
            return ResponseEntity.ok(updatedDirectory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectory(@PathVariable Long id) {
        Directory existingDirectory = directoryService.getDirectoryById(id);
        if (existingDirectory != null) {
            directoryService.deleteDirectory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveDirectory")
    public String saveDirectory(@ModelAttribute Directory directory, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        directory.setAuthor(loggedInUser);
        directoryService.saveDirectory(directory);

        return "redirect:/mainPage"; // Redirect to the createDirectory page after saving.
    }
    @GetMapping("/userDirectories")
    public List<Directory> getAllUserDirectories(@ModelAttribute Directory directory, HttpSession session, Model model) {

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        List<Directory> userDirectories = directoryService.getDirectoriesByUserId(loggedInUser.getId());
        model.addAttribute("directories", userDirectories);




        return directoryService.getAllDirectories();
    }
}