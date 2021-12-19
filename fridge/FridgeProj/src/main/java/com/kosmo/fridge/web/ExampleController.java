package com.kosmo.fridge.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo.fridge.service.ExampleDTO;
import com.kosmo.fridge.service.impl.ExampleServiceImpl;

@Controller
public class ExampleController {
	
	@Resource(name="exampleService")
	private ExampleServiceImpl exampleService;
	
	//example에 있는 song의 list를 가져오는 메소드
	@CrossOrigin
	@GetMapping("/songs")
	public String list(Model model){
		List<ExampleDTO> listExample=exampleService.selectList();
		model.addAttribute("list",listExample);
		return "example/Example";
	}
}