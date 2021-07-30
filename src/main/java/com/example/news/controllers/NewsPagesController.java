package com.example.news.controllers;


import com.example.news.models.Posting;
import com.example.news.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NewsPagesController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/newspage")
    public String newsMain(Model model) {
        Iterable<Posting> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "newspage";
    }

    @GetMapping("/newspage/addpage")
    public String addPage(Model model) {

        return "addpage";
    }

    @PostMapping("/newspage/addpage")
    public String newsAdd(@RequestParam String title, @RequestParam String full_text, @RequestParam String tag, Model model){
        Posting papers = new Posting(title, full_text, tag);
        postRepository.save(papers);
        return "redirect:/newspage";
    }

    @GetMapping("/news/{id}")
    public String paperDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){

            return "redirect:/newspage";
        }

        Optional<Posting> paper = postRepository.findById(id);
        ArrayList<Posting> result = new ArrayList<>();
        paper.ifPresent(result::add);
        model.addAttribute("paper", result);
        return "paperdetails";
    }

    @GetMapping("/news/{id}/edit")
    public String paperEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){

            return "redirect:/newspage";
        }

        Optional<Posting> paper = postRepository.findById(id);
        ArrayList<Posting> result = new ArrayList<>();
        paper.ifPresent(result::add);
        model.addAttribute("paper", result);
        return "paper-edit";
    }


    @PostMapping("/news/{id}/edit")
    public String newsUpdate(@PathVariable(value = "id") long id,@RequestParam String title,
                             @RequestParam String full_text, @RequestParam String tag, Model model){

        Posting paper = postRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new AssertionError();
        });
        paper.setTitle(title);
        paper.setFull_text(full_text);
        paper.setTag(tag);
        postRepository.save(paper);
        return "redirect:/newspage";
    }

    @PostMapping("/news/{id}/delete")
    public String newsDelete(@PathVariable(value = "id") long id, Model model){
        Posting paper = postRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new AssertionError();
        });
        postRepository.delete(paper);

        return "redirect:/newspage";
    }
}
