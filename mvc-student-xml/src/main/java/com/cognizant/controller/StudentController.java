package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("view")
	public String viewController(ModelMap model) {
		List<Student> students = studentService.getAll();
		model.put("students", students);
		return "view";
	}
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insertGet(ModelMap model) {
		return "insert";
	}
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertPost(@RequestParam int id,
			@RequestParam String name, @RequestParam float marks, ModelMap model) {
		if(studentService.insert(id, name, marks))
		{
			return "redirect:/view";
		}
		model.put("error", "Record Insertion failed");
		return "insert";
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateGet(ModelMap model) {
		return "update";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePost(@RequestParam int id,
			@RequestParam String name, @RequestParam float marks, ModelMap model) {
		if(studentService.update(id, name, marks))
		{
			return "redirect:/view";
		}
		model.put("error", "Record Updation failed");
		return "update";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteGet(ModelMap model) {
		return "delete";
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String deletePost(@RequestParam int id, ModelMap model) {
		if(studentService.delete(id))
		{
			return "redirect:/view";
		}
		model.put("error", "Record Deletion failed");
		return "delete";
	}
}
