package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

	@Autowired
	private PersonDao personDao;

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("personList", personDao.getAll());
		return "index";
	}

}
