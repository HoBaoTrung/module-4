package com.codegym.songupload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class SongController {

    private final List<Song> songs = new ArrayList<>();
    private final List<String> allowedExtensions = new ArrayList<>(Arrays.asList(".mp3", ".wav", ".ogg", ".m4p"));

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@ModelAttribute Song song,
                               @RequestParam("file") MultipartFile file,
                               RedirectAttributes redirectAttributes) throws IOException {

        // ✅ Kiểm tra định dạng file
        String filename = file.getOriginalFilename();
        if (filename == null || !filename.matches(".*\\.(mp3|wav|ogg|m4p)$")) {
            redirectAttributes.addFlashAttribute("message", "Chỉ cho phép các file .mp3, .wav, .ogg, .m4p");
            return "redirect:/upload";
        }
        String filePath = "C:\\Users\\ASUS\\Desktop\\module-4\\Data Binding - Form\\song-upload\\src\\main\\webapp\\uploads\\" + filename;

        FileCopyUtils.copy(file.getBytes(), new File(filePath));
        song.setFilePath(filename);
        songs.add(song);
        return "redirect:/songs";
    }

    @GetMapping("/songs")
    public String showSongs(Model model) {
        model.addAttribute("songs", songs);
        return "list";
    }
}
