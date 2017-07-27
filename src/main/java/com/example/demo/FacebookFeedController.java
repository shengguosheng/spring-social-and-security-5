package com.example.demo;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class FacebookFeedController {

	private Facebook facebook;

	public FacebookFeedController(Facebook facebook) {
		this.facebook = facebook;
	}
	
	@GetMapping
	public String feed(Model model) {
		PagedList<Post> feed = facebook.feedOperations().getFeed();
		model.addAttribute("feed", feed);
		System.out.println(" --> " + facebook);
		System.out.println(" --> " + feed);
		return "facebook/feed";
	}
	
}
