package hello;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.ui.Model;

@Controller
public class WebController implements WebMvcConfigurer {
	private String appMode;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
		/*
		 * registry.addViewController("/list").setViewName("list");
		 * registry.addViewController("/userform").setViewName("userform");
		 * registry.addViewController("/home").setViewName("home");
		 */

	}

	@Autowired
	public WebController(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("datetime", new Date());
		model.addAttribute("username", "Freddy");
		model.addAttribute("mode", appMode);

		return "home";
	}

	

}