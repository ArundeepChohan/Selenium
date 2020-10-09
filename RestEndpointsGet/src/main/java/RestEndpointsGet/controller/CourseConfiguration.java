package RestEndpointsGet.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {
 private String name;
 private String chapterCount;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getChapterCount() {
	return chapterCount;
}
public void setChapterCount(String chapterCount) {
	this.chapterCount = chapterCount;
}
 
}
