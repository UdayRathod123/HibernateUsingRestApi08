package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BikkadIT.model.User;
import com.BikkadIT.service.ServiceI;



public class EmployeeController {


	@Autowired
	private ServiceI serviceI;

	@GetMapping("/registration")
	public String preregister() {
		
		return "registration";
		
	}
	
	@PostMapping("/reg")
	public String saveUserController(User user, Model model) {
		System.out.println("Controller layer");
		System.out.println(user);
		int id = serviceI.saveUserService(user);
		model.addAttribute("id", id);
		System.out.println(id);
		return "reg";
		
	}
	
	@GetMapping("/getAllData")
	public String getAllUserController(Model model)
	{
		List<User> list = serviceI.getAllUsersService();
		System.out.println(list);
		model.addAttribute("list",list);
		
		return "getAllData";
		
	}
	
	
	@GetMapping("/login")
	public String preLogin()
	{
		return "login";
	}
	
	@PostMapping("/log")
	public String loginCheck(User user,Model model)
	{
		System.out.println(user);
		User user1 = serviceI.loginCheck(user);
		
		if(user1==null)
		{
			return "LoginFail";
		}
		
		return "LoginSuccess";
		
	}
	
	
	//Edit & Update
	
	@GetMapping("/edit/{uid}")
	public String editUser(@PathVariable int uid, Model model)
	{
		User user = serviceI.editUser(uid);
		model.addAttribute("user",user);
		
		return "edit";
		
	}
	
	@GetMapping("/up")
	public String preUpdate()
	{
		return "up";
		
	}
	
	@PostMapping("/update")
	public String updateUser(User user,Model model) 
	{
		User user2 = serviceI.update(user);
		model.addAttribute("user2", user2);
		
		return "update";
		
	}
	
	//Delete
	
	@GetMapping("/delete/{uid}")
	public String deleteUser(@PathVariable int uid)
	{
		User user = serviceI.delete(uid);
		System.out.println(user);
		if(user!=null) 
		{
		   return "delete";
		}
		return "notdelete";
		
	}
}
