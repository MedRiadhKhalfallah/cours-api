package io.javabrians.springbootstarter.topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping("/topics")
	public List<Topic>getAllTopics()
	{
		return topicService.getAllTopics();
	}
	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Integer id)
	{
		return topicService.getTopic(id);
	}
	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		 topicService.addTopic(topic);
	}
	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable Integer id)
	{
		 topicService.updateTopic(topic);
	}
	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic( @PathVariable Integer id)
	{
		 topicService.deleteTopic(id);
	}
	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping("/topics/recherche")
	public List<Topic>rechercheTopics(@RequestParam(name="nt",defaultValue="") String nt)
	{
		return topicService.rechercheTopic(nt);
	}
	
	@RequestMapping("/getLogedUser")
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest)
	{
		HttpSession httpSession=httpServletRequest.getSession();
		SecurityContext securityContext= (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username= securityContext.getAuthentication().getName();
		List<String> roles= new ArrayList<>();
		for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params= new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}
}
