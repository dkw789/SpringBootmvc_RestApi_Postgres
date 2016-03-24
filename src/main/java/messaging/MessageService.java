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


/*	public List<Message> goToIndividual( String user1,  String user2) throws Exception {


			if(user1!= null && user2 != null){
				return  repo.findByUserNameAndUserName2(user1, user2);
			}
		else {
				throw new Exception("Need two users for retrieve conversation");
			}



	}*/
public List<Message> goToIndividual( String user1) throws Exception {


	if (user1 != null ) {
		return repo.findByUserName(user1);

	} else {
		throw new Exception("Need Username to retrieve conversation");
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
		Message update = repo.findOne(id);
		update.setUserName(m.getUserName());
		update.setUserName2(m.getUserName2());
		update.setParentMessageID(m.getParentMessageID());
		update.setLocation(m.getLocation());
		update.setLatitude(m.getLatitude());
		update.setLongitude(m.getLongitude());
		update.setTemperature(m.getTemperature());
		update.setMessageContent(m.getMessageContent());
		// update.setCreatedAt(m.getCreatedAt()));
		m.setCreatedAt(new Date());
		return repo.save(update);

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


}
