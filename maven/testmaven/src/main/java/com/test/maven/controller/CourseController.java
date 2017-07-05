package com.test.maven.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showUploadPage(String s){
		
		return "course_admin/file";
	}
	
	
}
