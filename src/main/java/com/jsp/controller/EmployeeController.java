package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Employee;
import com.jsp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@RequestMapping("/loademployee")// type url loademployee
	public ModelAndView load() {
		
		ModelAndView andView=new ModelAndView("saveemployee.jsp");
		andView.addObject("load",new Employee());
		return	andView; 
	}

	@RequestMapping("/saveemployee")
		public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		
			Employee employee2=employeeService.saveEmployee(employee);
			
			if(employee2!=null) {
				ModelAndView andView=new ModelAndView("index.jsp");
				andView.addObject("msg","data saved");
				return andView;
			}
			else 
			{
				ModelAndView andView=new ModelAndView("/load");
				return andView;
			}
		}
	
	@RequestMapping("/displayemployee")//type url displayemployee
	public ModelAndView displayEmployee() {
		
		ModelAndView andView=new ModelAndView("displayemployee.jsp");
		andView.addObject("list",employeeService.getAllEmployee());
		return andView;
	}
	
	
	
	
	@RequestMapping("/editemployee")
	public ModelAndView editEmployee(@RequestParam int id) {
		
		ModelAndView modelAndView = new ModelAndView("updateemployee.jsp");
		modelAndView.addObject("emp" , employeeService.getEmployeeById(id)) ;
		return modelAndView ;
	}
	
	
	
	@RequestMapping("/updateemployee")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		
		Employee employee2=employeeService.updateEmployee(employee) ;
		
		ModelAndView modelAndView = new ModelAndView("/displayemployee");
		return modelAndView ;
	}

	
	@RequestMapping("/deleteemployee")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		
		Employee employee=employeeService.deleteEmployee(id) ;
		ModelAndView modelAndView = new ModelAndView("/displayemployee");
		return modelAndView ;
	}
	
}


