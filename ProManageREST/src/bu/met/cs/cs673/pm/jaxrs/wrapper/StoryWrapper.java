package bu.met.cs.cs673.pm.jaxrs.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import bu.met.cs.cs673.pm.jaxrs.model.Story;

@XmlRootElement(name = "wrapper")
public class StoryWrapper {
	
	
	private List<Story> stories;

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

}
