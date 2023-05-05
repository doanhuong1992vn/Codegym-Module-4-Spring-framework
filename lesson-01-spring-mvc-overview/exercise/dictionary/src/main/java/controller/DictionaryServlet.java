package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ISearchService;

@Controller
public class DictionaryServlet {
    @Autowired
    private ISearchService searchService;
    @GetMapping("/")
    public ModelAndView getDictionaryForm() {
        return new ModelAndView("index");
    }
    @GetMapping("/search")
    public ModelAndView getResult(@RequestParam String word) {
        String result = searchService.search(word);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject( "result", result);
        modelAndView.addObject( "word", word);
        return modelAndView;
    }
}
