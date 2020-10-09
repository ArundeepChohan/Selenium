package RestEndpointsGet.controller;

public class Course {

	private String name;
	private String chapterCount;
	public Course(String name, String chapterCount)
	{
		this.setName(name);
		this.setChapterCount(chapterCount);
	}
	public String getChapterCount() {
		return chapterCount;
	}
	public void setChapterCount(String chapterCount) {
		this.chapterCount = chapterCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
