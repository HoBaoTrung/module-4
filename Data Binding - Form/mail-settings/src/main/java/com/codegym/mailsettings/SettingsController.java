package com.codegym.mailsettings;;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SettingsController {

    private MailSettings currentSettings = new MailSettings();

    public SettingsController() {
        // Default settings
        currentSettings.setLanguage("English");
        currentSettings.setPageSize(25);
        currentSettings.setSpamsFilter(false);
        currentSettings.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping("/settings")
    public String showSettingsForm(Model model) {
        model.addAttribute("settings", currentSettings);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "settings";
    }

    @PostMapping("/settings")
    public String updateSettings(@ModelAttribute MailSettings settings, Model model) {
        this.currentSettings = settings;
        model.addAttribute("settings", currentSettings);
        return "settings-view";
    }
}
