package com.cignex.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.constant.Constant;


@RestController
public class FileUpload {

	@PostMapping("/upload")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile[] files) throws IOException{
		Path path = null;
		String pathh = null;
		for (MultipartFile file : files) {
			pathh = Constant.UPLOAD_DIRECTORY + file.getOriginalFilename();
			path = Paths.get(pathh);
			Files.write(path, file.getBytes());
		}
		return "sucessfully upload"+pathh;
		
	}
}
