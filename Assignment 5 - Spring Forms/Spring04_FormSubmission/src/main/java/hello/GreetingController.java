package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GreetingController {

    /**
     * Called when hitting "http://localhost:8081/greeting"
     * Called when hitting "http://localhost:8081/greeting2"
     * *
     *
     * @param model
     * @return
     */
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        System.out.println("###### Form Greeting=" + greeting.toString());
        return "result";
    }

    // try #2 ... with session attributes
    @GetMapping("/greeting2")
    public String greetingForm2(Model model, HttpSession session) {

        // Create a greeting, and store it as a session variable
        Greeting SessionGreeting = (Greeting) session.getAttribute("sessionGreeting");

        if (SessionGreeting == null) {
            SessionGreeting = new Greeting();
            SessionGreeting.setId(777);
            SessionGreeting.setContent("Inserted by controller");
            session.setAttribute("sessionGreeting", SessionGreeting);
            System.out.println("###### Created Session Greeting=" + SessionGreeting.toString());
        }

        // Get client IP.  Don't use localhost, use your IP instead
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String ip = request.getRemoteAddr();
        System.out.println("###### Form Session Greeting=" + SessionGreeting.toString() + " IP=" + ip);

        model.addAttribute("greeting", SessionGreeting);
        return "greeting2";
    }

    @PostMapping("/greeting2")
    public String greetingSubmit2(Model model, @ModelAttribute Greeting greeting, HttpSession session) {

        System.out.println("###### Form Greeting=" + greeting.toString());

        // Copy submitted form into the session attribute...just playing around
        session.setAttribute("sessionGreeting", greeting);

        System.out.println("###### Form Session Greeting=" + greeting.toString());

        return "result2";
    }

}