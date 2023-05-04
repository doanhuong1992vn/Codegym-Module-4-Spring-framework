package controller;

import domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloServlet {
    @Autowired
    private Message message;
    @RequestMapping("message")
    public String hello() {
        return message.getMessage();
    }
}