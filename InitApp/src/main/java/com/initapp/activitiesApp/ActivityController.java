package com.initapp.activitiesApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActivityController {
	
	@Autowired
	private ActivityRepository activityRepo;
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="0") int page){
		
		model.addAttribute("data", activityRepo.findAll(new PageRequest(page, 4)));
		model.addAttribute("currentPage", page);
		return "index";
	}

	@PostMapping("/save")
	public String save(Activity a) {
		String savingType;
		if(a.getId() != null)
			savingType = "edit";
		
		else
			savingType = "new";
		activityRepo.save(a);
		return "redirect:/?type="+savingType;
	}
	
	@GetMapping("/delete")
	public String deleteActivity(Integer id) {
		activityRepo.deleteById(id);
		return "redirect:/?type=delete";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Optional<Activity> findOne(Integer id) {
		
		return activityRepo.findById(id);
		
		
	}
}
