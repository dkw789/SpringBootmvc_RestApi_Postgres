/*
 * Description : This is the controller of Spring MVC framework. The controller does the CRUD same as default CRUD
 * provided by MongoRepository. But using controller allows more customizations and able to generate a interface as
 * view.
 */

package messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
class MessageService {

	@Autowired
	private MessageRepository repo;


	public List<Message> getAll() {

		return (List<Message>) repo.findAll();

	}


	public List<Message> goToIndividual( String user1,  String user2) throws Exception {


			if(user1!= null && user2 != null){
				return  repo.findByUserNameAndUserName2(user1, user2);
			}
		else {
				throw new Exception("Need two users for retrieve conversation");
			}



	}

	public Message goToIndividual( Long id) {
		return repo.findOne(id);

	}


	public Message create( Message m) {
		m.setCreatedAt(new Date());
		return repo.save(m);
	}


	public void delete( Long id) {
		repo.delete(id);
	}

	public Message update( Long id,  Message m) {
//		Message update = repo.findOne(id);
//
//		update.setUserName(m.getUserName());
//		update.setUserName2(m.getUserName2());
//		update.setMessageID(m.getMessageID());
//		update.setLocation(m.getLocation());
//		update.setLatitude(m.getLatitude());
//		update.setLongitude(m.getLongitude());
//		update.setTemperature(m.getTemperature());
//		update.setMessageContent(m.getMessageContent());
//		// update.setCreatedAt(m.getCreatedAt()));

		return repo.save(m);

	}


	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Message());
		return "greeting";
	}


	public String greetingSubmit( Message greeting, Model model) {
		greeting.setCreatedAt(new Date());
		repo.save(greeting);
		model.addAttribute("greeting", greeting);
		// return "redirect:/Message/greeting/result";
		return "result";
	}


	public Map<String, Object> showAllMessages(Model model) {

		// model.addAttribute("Messages", repo.findAll());
		// return repo.findAll();

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("MessageContent", "Message created successfully");
		response.put("UserName", "Admin");
		return response;

	}

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	// public Map<String, String> hello() {
	// return Collections.singletonMap("message",
	// this.repo.findOne());
	// }
	//
	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// @ResponseBody
	// public Map<String, Object> {
	// Map<String, Object> model = new LinkedHashMap<String, Object>();
	// model.put("UserName", "Omar");
	// model.put("MessageContent", "Hello Home");
	// model.put("date", new Date());
	// return model;
	// }


	public String foo() {
		throw new IllegalArgumentException("Server error");
	}

	// @RequestMapping("/messagesAjaxRequest")
	// public @ResponseBody List<Message> messagesAjaxRequest(@ModelAttribute("MessageForm") Message MessageForm,
	// ModelMap model) {
	//
	// MessageBO.prepareMessageList(MessageForm,model);
	//
	// return MessageForm.getMessageList();
	// }
	// @RequestMapping(value="/allText{id}", produces = "html/plain;charset=UTF-8")
	// @ResponseBody
	// public String allText(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart,Model model)
	// {
	// Message m = m.getUserName(id);
	// if (product != null) {
	// CartLine line = new CartLine();
	// line.setProduct(product);
	// line.setQuantity(1);
	// productService.updateProduct(product);
	// }
	// return "<div>output</div>";
	// }
}
