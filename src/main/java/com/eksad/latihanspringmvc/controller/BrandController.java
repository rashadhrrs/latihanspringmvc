package com.eksad.latihanspringmvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.model.Product;
import com.eksad.latihanspringmvc.repository.BrandDao;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;

@Controller
@RequestMapping("/brand")

public class BrandController {
	
	@Autowired
	BrandRepositoryDAO brandRepositoryDAO;
	
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Brand> list = brandRepositoryDAO.findAll();
		
		for (Brand p : list) {
			
		}
		model.addAttribute("listBrand", list);
		
		return "listBrand";
		
		
	}
	
	@RequestMapping("/add")
	public String addBrand(Model model) {
		Brand brand = new Brand();
		
		model.addAttribute("brand", brand);
		
		return "addBrand";
	}
	
	@RequestMapping("/delete")
	public String deleteBrand(Model model) {
		Brand brand = new Brand();
		
		
		return "deleteBrand";
	}
	
	@RequestMapping (value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandRepositoryDAO.save(brand);
		
		return "redirect:/brand";
		
	}
	
	
	
	@RequestMapping("/delete/{id}")

	
	public String delete(@PathVariable Long id) {
		brandRepositoryDAO.delete(id);
		
		return "redirect:/brand";
		
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBrand(@PathVariable Long id, Model model) {
		Brand brand = brandRepositoryDAO.findOne(id);
		model.addAttribute("brand",brand);
		
		return "addbrand";
	}
	
}
	


