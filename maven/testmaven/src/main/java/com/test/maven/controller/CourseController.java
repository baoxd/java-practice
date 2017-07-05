package com.test.maven.controller;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.maven.model.Course;
import com.test.maven.service.CourseService;



@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	
	//本方法将处理 /courses/view?courseId=123 形式的URL
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId,
			Model model) {
		
		log.debug("In viewCourse, courseId = "+courseId);
		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
	
	
	@RequestMapping("/view2/{courseId}")
	public String viewCourse2(@PathVariable("courseId") Integer courseId, 
			Map<String, Object> model){
		
		log.debug("In viewCourse2, courseId = {} ", courseId);
		
		Course course = courseService.getCoursebyId(courseId);
		model.put("course", course);
		return "course_overview";
	}
	
	@RequestMapping("/view3")
	public String viewCourse3(HttpServletRequest request){
		
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Course course = courseService.getCoursebyId(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
	public String createCourse(){
		return "course_admin/edit";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String doSave(@ModelAttribute Course course){
		log.debug("Info of Course:");
		log.debug(ReflectionToStringBuilder.toString(course));
		
		course.setCourseId(123);
		return "redirect:view2/" + course.getCourseId();
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String showUploadPage(@RequestParam(value="multi", required=false) Boolean multi) {
		
		if(multi != null && multi){
			return "course_admin/multifile";
		}
		
		return "course_admin/file";
	}
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		
		if(!file.isEmpty()){
			log.debug("Process file:{}", file.getOriginalFilename());
			uploadFile(file);
		}
		return "success";
	}
	
	
	@RequestMapping(value="/doUpload2", method=RequestMethod.POST)
	public String doUploadFile2(MultipartHttpServletRequest multiRequest){
		
		Iterator<String> fileNames = multiRequest.getFileNames();
		int total = 0 ;
		int uploadSuccess = 0;
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile file = multiRequest.getFile(fileName);
			total++ ;
			
			if(!file.isEmpty()){
				log.debug("Process file:{}", file.getOriginalFilename());
				try {
					uploadFile(file);
					uploadSuccess++ ;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(total == uploadSuccess){
			return "success";
		}else{
			// ....
		}
		return "success";
	}
	
	
	/**
	 * 文件上传
	 * @throws IOException 
	 */
	public void uploadFile(MultipartFile file) throws IOException{
		
		if(!file.isEmpty()){
			File desFile = new File("D:\\workspace\\java\\uploads", System.currentTimeMillis() + file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), desFile);
		}
	}
	
	@RequestMapping(value="/{courseId}", method=RequestMethod.GET)
	public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId){
		return courseService.getCoursebyId(courseId);
	}
	
	
	@RequestMapping(value="/jsontype/{courseId}", method=RequestMethod.GET)
	public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId){
		Course course = courseService.getCoursebyId(courseId);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	
}
