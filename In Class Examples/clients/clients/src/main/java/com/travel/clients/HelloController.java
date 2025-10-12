package com.travel.clients;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





//browser cookie
//session

@Controller
@SessionAttributes({"username","counter"}) // part1
public class HelloController {

ArrayList<Staff> AllStaff = new ArrayList<Staff>();




    @RequestMapping("/clients")
    public String getHello(Model model) {
// create arraylist

   ArrayList<Clients> clients = new ArrayList<Clients>(); // creating arraylist of objects instead of string




    clients.add(new Clients("Nadia", "Nadia@Nadia.com", "902-111-1111"));
    clients.add(new Clients("Esraa", "Esraa@Esraa.com", "902-111-1111"));
    clients.add(new Clients("Josh", "Josh@Josh.com", "902-222-3333"));
    
//fn ... final output


    model.addAttribute("clientsData", clients); //used in client.html
    model.addAttribute("msg", "List of the Clients");
    model.addAttribute("date", LocalDate.now()); // used in client.html
   // model.addAttribute("title", "♥Clients Data♥");


        return "client";  
    }







// for login , you need to add the lines from 50 to 65 and to create two html pages (login and welcome )
 @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,@RequestParam String password, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("counter", 0);
    if ("Nadia".equals(username)  && "love".equals(password)) {
        return "welcome";
} else {
        model.addAttribute("error", "invalid username ");
        return "login";
        }

    }


 

@PostMapping("/click")
    public String countClick(@ModelAttribute("counter") Integer counter, Model model) {

       counter++;

        model.addAttribute("counter", counter);

    return "welcome";

    }



    @GetMapping("/logout") // it is a link to button , so GetMapping

public String logout(HttpSession session) {

session.invalidate();

    return "redirect:/login";

    }




//
     

@GetMapping("/staff") // adding new staff 

public String addnewstaff(Model model) {

Staff mystaff = new Staff();
model.addAttribute("addNewStaff", mystaff);
    return "addnewstaff";
}





// postMapping : to submit the form and to take end user to getallstaff page






@PostMapping("/dataSubmitForm")
    public String dataSubmitForm(Staff staff) {
        AllStaff.add(staff);
        return "redirect:/getAllstaff";
    }

    @GetMapping("/getAllstaff")
    public String getAllstaff(Model model) {
        model.addAttribute("AllStaff", AllStaff);
        return "getallstaff";
    }





     
}
