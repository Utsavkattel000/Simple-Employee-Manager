package com.example.springproject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload")
  public String getUpload() {
		
	  return "UploadForm";
  }
	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile image, Model model){
		if(!image.isEmpty()) {
			try {
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/Photos/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING );
			   model.addAttribute("message", "Upload success");
			   return "UploadForm";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("message", "Upload failed");  
		return "UploadForm";
	}
}
