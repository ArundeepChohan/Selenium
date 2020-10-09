package RestEndpointsGet.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {
	@Value("${course.name}")
	private String cname;
	@Value("${course.chapterCount}")
	private String chaptersCount;
	@Autowired
	private CourseConfiguration courseConfiguration;
	@RequestMapping("/default")
	public Course getDefault(@RequestParam(value="name",defaultValue="Spring Boot", required = false) String name,
							 @RequestParam(value="chapterCount",defaultValue="2", required = false) String chapterCount){
		return new Course(cname,chaptersCount);
	}
	@RequestMapping("/getConfig")
	public HashMap<String,Object> getConfig(@RequestParam(value="name",defaultValue="Spring Boot", required = false) String name,
							                @RequestParam(value="chapterCount",defaultValue="2", required = false) String chapterCount){
		HashMap<String,Object> map = new HashMap<>(); 
		map.put("name", courseConfiguration.getName());
		map.put("chapterCount", courseConfiguration.getChapterCount());
		return map;
	}
	@RequestMapping("/course")
	public Course getEndPoint(@RequestParam(value="name",defaultValue="Spring Boot", required = false) String name,
							  @RequestParam(value="chapterCount",defaultValue="2", required = false) String chapterCount){
		return new Course(name,chapterCount);
	}
	@RequestMapping(method=RequestMethod.POST,value="/register/course")
	public String saveCourse(@RequestBody Course course)
	{
		return course.getName() +" "+ course.getChapterCount();
	}
}
