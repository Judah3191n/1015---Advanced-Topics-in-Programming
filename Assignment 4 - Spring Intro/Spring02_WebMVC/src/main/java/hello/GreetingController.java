package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GreetingController {
    public static int addressHit = 0;
    public static int greetingHit = 0;
    public static int totalAddressHit = 0;
    public static int totalGreetingHit = 0;

    /**
     * Called when hitting "http://localhost:8081/greeting1"
     * "http://localhost:8081/greeting2"
     * "http://localhost:8081/greeting2?name=RussyPoo"
     * "http://localhost:8081/greeting3"
     *
     * Swaps return string into HTML so that ...
     * <p th:text="'Hello, ' + ${name} + '!'" />
     * ... becomes ...
     * <p th:text="'Hello, ' + "String returned from here" + '!'" />
     *
     * @param name  Name defaults to "World" if not specified
     * @param model
     * @return String name of view HTML file to use, parameters are replaced.
     */
    @GetMapping("/greeting1")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);

        // return string is used to find HTML template to use
        // finds greeting1.html in the templates
        return "greeting1";
    }

    @GetMapping("/greeting2")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "Russ") String name,
            @RequestParam(name = "magicNum", required = false, defaultValue = "5726") String magicNum,
            HttpSession session, Model model) {

        System.out.println("###### Session =" + session.toString());

        model.addAttribute("name", name);
        model.addAttribute("magicNum", magicNum);

        System.out.println("###### Session =" + model.toString());

        return "greeting2";
    }

    @GetMapping("/greeting3")
    public String greeting3(@RequestParam(name = "name", required = false, defaultValue = "Russ") String name,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("phone", "333-9191");
        model.addAttribute("email", "russy.poo@nscc.ca");
        return "greeting3";
    }

    @GetMapping("greeting")
    public String greeting1(Model model) {
        greetingHit++;

        String colour = "Blue";
        model.addAttribute("favColour", colour);
        return "greeting";
    }

    @GetMapping("/address")
    public String getMethodName(Model model) {
        addressHit++;

        String address = "1234";
        String city = "London";
        String country = "England";
        String street = "Dury Lane";
        int houseNum = 1;

        model.addAttribute("houseNum", houseNum);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("country", country);
        model.addAttribute("street", street);
        return "address";
    }

    @GetMapping("/reset")
    public String getReset(Model model) {
        totalAddressHit += addressHit;
        totalGreetingHit += greetingHit;
        model.addAttribute("totalAddressHit", totalAddressHit);
        model.addAttribute("totalGreetingHit", totalGreetingHit);
        model.addAttribute("addressHit", addressHit);
        model.addAttribute("greetingHit", greetingHit);

        addressHit = 0;
        greetingHit = 0;

        return "reset";
    }

}