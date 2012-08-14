package com.wwt.reminder.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wwt.reminder.model.Informer;
import com.wwt.reminder.model.InformerType;
import com.wwt.reminder.model.User;
import com.wwt.reminder.repository.UserRepository;

@Controller
@SessionAttributes("currentUser")
public class InformerController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="informer",method=RequestMethod.GET)
	public String showInformer(Model model,@ModelAttribute("currentUser") User currentUser) {
		model.addAttribute("option", createSelectString());
		if (currentUser.getInformers()!=null) {
			model.addAttribute("informers", currentUser.getInformers());
		}
		return "informer";
	}
	

	@RequestMapping(value="informer",method=RequestMethod.POST)
	public String addInformer(@ModelAttribute("currentUser") User currentUser, Informer informer) {
		if ((currentUser.getInformers()!=null)&&(currentUser.getInformers().contains(informer))) {
			return "error";
		}
		if (currentUser.getInformers()==null) {
			ArrayList<Informer> arrayList=new ArrayList<Informer>();
			currentUser.setInformers(arrayList);
		}
		currentUser.getInformers().add(informer);
		userRepository.save(currentUser);
		return "redirect:informer";
	}
	
	
	private String createSelectString() {
		StringBuilder stringBuilder=new StringBuilder();
		for (InformerType informerType : InformerType.values()) {
			stringBuilder.append("<option>"+informerType+"</option>");
		}
		return stringBuilder.toString();
	}

}
