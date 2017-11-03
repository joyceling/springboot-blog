package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String guessTheNumber() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String guessTheNumber(@PathVariable int number, String page, Model model) {

        int rollTheDice = (int) (Math.random() * 6 + 1);
        int rollTheDice2 = (int) (Math.random() * 6 + 1);
        int rollTheDice3 = (int) (Math.random() * 6 + 1);
        int[] diceArray = {rollTheDice, rollTheDice2, rollTheDice3};
        List<Integer> matchingList = new ArrayList<Integer>();

        for (int i = 0; i < diceArray.length; i++) {
            if (diceArray[i] == number) {
                matchingList.add(diceArray[i]);
            }
        }

        boolean match = (matchingList.size() > 0);
        int numberMatched = matchingList.size();

//        boolean match = (rollTheDice == number);

        model.addAttribute("roll", rollTheDice);
        model.addAttribute("roll2", rollTheDice2);
        model.addAttribute("roll3", rollTheDice3);

//        model.addAttribute("number", number);
        model.addAttribute("match", match);
        model.addAttribute("matchingList", matchingList);
        model.addAttribute("numberMatched", numberMatched);

        return "guess-number";
    }
}
