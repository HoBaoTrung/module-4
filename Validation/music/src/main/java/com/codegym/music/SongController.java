package com.codegym.music;

import com.codegym.music.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("song", new Song());
        return "song-form";
    }

    @PostMapping("/save")
    public String saveSong(@Valid @ModelAttribute("song") Song song,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "song-form";
        }
        // Save or update logic here
        model.addAttribute("message", "Lưu bài hát thành công!");
        return "song-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        // Giả sử lấy được bài hát từ DB
        Song song = new Song();
        song.setId(id);
        song.setName("Bài hát mẫu");
        song.setArtist("Ca sĩ A");
        song.setGenre("Pop, Ballad");

        model.addAttribute("song", song);
        return "song-form";
    }
}