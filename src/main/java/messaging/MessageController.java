/*
 * Description : This is the controller of Spring MVC framework. The controller does the CRUD same as default CRUD provided by MongoRepository. But using controller allows more customizations and able to generate a interface as view.
 * */

package messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Message")
class MessageController {

    @Autowired
    private MessageRepository repo;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getAll() {
//        List<Message> msg = (ArrayList<Message>) repo.findAll();
        return (List<Message>) repo.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ResponseBody
    public Message goToIndividual(@PathVariable Long id) {
        return repo.findOne(id);

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Message create(@RequestBody Message m) {
        return repo.save(m);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable Long id) {
        repo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Message update(@PathVariable Long id, @RequestBody Message m) {
      Message update = repo.findOne(id);

        update.setUserName(m.getUserName());
        update.setUserName2(m.getUserName2());
        update.setMessageID(m.getMessageID());
        update.setCreatedAt(m.getCreatedAt());
        update.setLocation(m.getLocation());
        update.setLatitude(m.getLatitude());
        update.setLongitude(m.getLongitude());
        update.setTemperature(m.getTemperature());
        update.setMessageContent(m.getMessageContent());


        return repo.save(update);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Message());
        return "greeting";
    }


    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Message greeting, Model model) {
        repo.save(greeting);
        model.addAttribute("greeting", greeting);
        //return "redirect:/Message/greeting/result";
        return "result";
    }


    @RequestMapping(value = "/Messages", method = RequestMethod.GET)
    public String showAllMessages(Model model) {


        model.addAttribute("Messages", repo.findAll());
        return "Messages/list";

    }

//    @RequestMapping("/messagesAjaxRequest")
//    public @ResponseBody List<Message> messagesAjaxRequest(@ModelAttribute("MessageForm") Message MessageForm, ModelMap model) {
//
//        MessageBO.prepareMessageList(MessageForm,model);
//
//        return MessageForm.getMessageList();
//    }
//    @RequestMapping(value="/allText{id}",  produces = "html/plain;charset=UTF-8")
//    @ResponseBody
//    public String allText(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart,Model model)
//    {
//        Message m = m.getUserName(id);
//        if (product != null) {
//            CartLine line = new CartLine();
//            line.setProduct(product);
//            line.setQuantity(1);
//            productService.updateProduct(product);
//        }
//        return "<div>output</div>";
//    }
}
    


