package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {
	@Autowired
	WorkRepo repo;
	@RequestMapping("/")
	public String details() {
		return "fview";
	}
	@PostMapping("/details")
	public String details(ListWork user) {
		repo.save(user);
		return "fview";
	}
	@RequestMapping("/getdetails")
	@ResponseBody
	public List<ListWork> getdetails(){
		return repo.findAll();
	}
	@RequestMapping("/getdetails/{date}")
	public ModelAndView getdetails2(@PathVariable("date") int date) {
		ModelAndView mv=new ModelAndView("Details");
		ListWork user=repo.findById(date).orElse(null);
		mv.addObject("user",user);
		return mv;
	}
	@PostMapping("/post")
	@ResponseBody
	public List<ListWork>post(@RequestBody ListWork user){
		repo.save(user);
		return repo.findAll();
	}
	@DeleteMapping("delete/{date}")
	@ResponseBody
	public List<ListWork>post(@PathVariable("date") int date){
		ListWork user=repo.getById(date);
		repo.delete(user);
		return repo.findAll();
	}
}




