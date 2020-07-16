package com.moses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moses.dao.StudentDAO;
import com.moses.pojo.Student;

@Controller
public class StudentController {

	@Autowired StudentDAO dao;
	
	@RequestMapping("list")
	public String list(Model m,@RequestParam(value="start",defaultValue="0") int start,@RequestParam(value="size",defaultValue="5") int size){
		start=0>start?0:start;
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Pageable pageable = new PageRequest(start, size,sort);
		Page<Student> page = dao.findAll(pageable);
		m.addAttribute("page", page);
		return "list";
	}
	
	@RequestMapping("edit")
	public String edit(int id,Model m){
		Student s = dao.findOne(id);
		m.addAttribute("s", s);
		return "edit";
	}
	
	@RequestMapping("update")
	public String update(Student student){
		dao.save(student);
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(int id){
		dao.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("add")
	public String add(Student s){
		dao.save(s);
		return "redirect:list";
	}
}
