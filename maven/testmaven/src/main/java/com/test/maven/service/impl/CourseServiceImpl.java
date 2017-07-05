package com.test.maven.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.maven.model.Chapter;
import com.test.maven.model.Course;
import com.test.maven.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService{
	
	
	public Course getCoursebyId(Integer courseId) {
		Course course = new Course();
		
		course.setCourseId(courseId);
		course.setTitle("深入浅出Java多线程");
		course.setImgPath("resources/imgs/course-img.jpg");
		course.setLearningNum(12345);
		course.setLevel(2);
		course.setLevelDesc("中级");
		course.setDuration(7200l);
		course.setDescr("多线程是日常开发中的常用知识，也是难用知识。bala bala...");
		
		List<Chapter> chapters = new ArrayList<Chapter>();
		
		warpChapterList(courseId, chapters);
		
		course.setChapterList(chapters);
		
		return course;
		
	}
	
	
	
	private void warpChapterList(Integer courseId, List<Chapter> chapterList){
		Chapter chapter = new Chapter();
		chapter.setId(1);
		chapter.setCourseId(courseId);
		chapter.setOrder(1);
		chapter.setTitle("第1章 多线程背景知识介绍");
		chapter.setDescr("本章将介绍与多线程编程相关的背景概念");	
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(3);
		chapter.setCourseId(courseId);
		chapter.setOrder(3);
		chapter.setTitle("第3章 Java 线程的正确停止");
		chapter.setDescr("本章讨论如何正确的停止一个线程，既要线程停得了，还得线程停得好。");		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(4);
		chapter.setCourseId(courseId);
		chapter.setOrder(4);
		chapter.setTitle("第4章 线程交互");
		chapter.setDescr("争用条件，线程的交互，及死锁的成因及预防。");		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(5);
		chapter.setCourseId(courseId);
		chapter.setOrder(5);
		chapter.setTitle("第5章 进阶展望");
		chapter.setDescr("简单介绍 Java 并发相关的类，及常用的多线程编程模型。");		
		chapterList.add(chapter);
	}
	
}
