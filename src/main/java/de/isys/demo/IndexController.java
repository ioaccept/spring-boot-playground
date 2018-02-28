package de.isys.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

	private final GreeterService greeterService;

	public IndexController(GreeterService greeterService) {
		this.greeterService = greeterService;
		System.out.println(greeterService.getClass());
	}

	@RequestMapping("/")
	public ModelAndView index() {
		final Map<String, Object> model = new HashMap<>();
		model.put("something_completely_different", "index request mapping");
		return new ModelAndView("hello_world", model);
	}

	@RequestMapping("/greet")
	public ModelAndView greet(@RequestParam String greet) {
		final HashMap<String, Object> model = new HashMap<>();

		greet = greeterService.transformation(greet);

		model.put("name_to_greet", greet);
		model.put("something_completely_different", Math.random());
		return new ModelAndView("hello_world", model);
	}

}
