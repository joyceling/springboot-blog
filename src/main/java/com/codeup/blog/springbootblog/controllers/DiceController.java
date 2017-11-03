package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String guessTheNumber() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String guessTheNumber(@PathVariable int number, String page, Model model) {

        int rollTheDice = (int) (Math.random() * 6 + 1);
        boolean match = (rollTheDice == number);

        model.addAttribute("roll", rollTheDice);
        model.addAttribute("number", number);
        model.addAttribute("match", match);

        return "guess-number";
    }
}
