package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController implements WebMvcConfigurer {
    static int unsuccessful = 0;

    // @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    /**
     * Called when hitting "http://localhost:8081/"
     * *
     * 
     * @param personForm
     * @return
     */
    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            unsuccessful++;
            return "form";
        }

        // return "redirect:/results";
        return "results";
    }

    @GetMapping("/address")
    public String getMethodName(Model model) {
        String street = "Dury lane";
        String City = "London";
        String Country = "England";

        model.addAttribute("street", street);
        model.addAttribute("city", City);
        model.addAttribute("country", Country);

        return "address";
    }

}