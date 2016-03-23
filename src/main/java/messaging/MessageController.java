/*
 * Description : This is the controller of Spring MVC framework. The controller does the CRUD same as default CRUD
 * provided by MongoRepository. But using controller allows more customizations and able to generate a interface as
 * view.
 */

package messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Message")

class MessageController {

	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Message> getAll() {

		return service.getAll();


	}

	@RequestMapping(method = RequestMethod.GET, params = { "user1" })
	@ResponseBody
	public List<Message> goToIndividual(@RequestParam("user1") String user1) throws Exception {


			return  service.goToIndividual(user1);

	}

/*	@RequestMapping(method = RequestMethod.GET, params = { "user1", "user2" })
	@ResponseBody
	public List<Message> goToIndividual(@RequestParam("user1") String user1, @RequestParam("user2") String user2) throws Exception {

			if(user1!= null && user2 != null){
				return  service.goToIndividual(user1, user2);

			}

		else {
				throw new Exception("Need two users to retrieve conversation");
			}



	}*/

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	@ResponseBody
	public Message goToIndividual(@PathVariable Long id) {
		return service.goToIndividual(id);

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Message create(@RequestBody Message m) {
		m.setCreatedAt(new Date());
		return service.create(m);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Message update(@PathVariable Long id, @RequestBody Message m) {
//		Message update = service.goToIndividual(id);
//		update.setUserName(m.getUserName());
//		update.setUserName2(m.getUserName2());
//		update.setMessageID(m.getMessageID());
//		update.setLocation(m.getLocation());
//		update.setLatitude(m.getLatitude());
//		update.setLongitude(m.getLongitude());
//		update.setTemperature(m.getTemperature());
//		update.setMessageContent(m.getMessageContent());
//		// update.setCreatedAt(m.getCreatedAt()));

		return service.create(m);

	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Message());
		return "greeting";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Message greeting, Model model) {
		greeting.setCreatedAt(new Date());
		service.create(greeting);
		model.addAttribute("greeting", greeting);
		// return "redirect:/Message/greeting/result";
		return "result";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public Map<String, Object> showAllMessages(@ModelAttribute Model model) {

		// model.addAttribute("Messages", repo.findAll());
		// return repo.findAll();

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("MessageContent", "Message created successfully");
		response.put("UserName", "Admin");
		return response;

	}


	@RequestMapping(value = "/getText", method = RequestMethod.GET)
	public String getText(String Text){
		if (Text != null)
		  return Text;

		else {
			//return "Please input text.";
			return"getText";
		}
	}

    @RequestMapping(value = "/listing", method = RequestMethod.GET)
    public String getListing(String listing){
        if (listing != null)
            return listing;

        else {
            //return "Please input text.";
            return"listing";
        }
    }


}

