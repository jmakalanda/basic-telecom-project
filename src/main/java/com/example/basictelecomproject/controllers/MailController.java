package com.example.basictelecomproject.controllers;

import com.example.basictelecomproject.domain.MailObject;
import com.example.basictelecomproject.services.EmailService;
import com.example.basictelecomproject.services.EmailServiceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    EmailService emailService;

/*    @Value("${attachment.invoice}")
    private String attachmentPath;*/

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showEmailsPage() {
        return "emails";
    }

    @RequestMapping(value = {"/send"}, method = RequestMethod.GET)
    public String createMail(Model model,
                             HttpServletRequest request) {
        String action = request.getRequestURL().substring(
                request.getRequestURL().lastIndexOf("/") + 1
        );
        Map<String, String> props = labels.get(action);
        Set<String> keys = props.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            model.addAttribute(key, props.get(key));
        }

        model.addAttribute("mailObject", new MailObject());
        return "send";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String createMail(Model model,
                             @ModelAttribute("mailObject") @Valid MailObject mailObject,
                             Errors errors) {
        if (errors.hasErrors()) {
            return "send";
        }
        emailService.sendSimpleMessage(mailObject.getTo(),
                mailObject.getSubject(), mailObject.getText());

        return "emails";
    }

}

