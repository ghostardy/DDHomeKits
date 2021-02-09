package family.dd.DDHomeKits.HomePage.interfaces.facade;

import family.dd.DDHomeKits.HomePage.interfaces.dto.PublishedMessageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static family.dd.DDHomeKits.HomePage.infrastructure.util.CommonUtil.isEmptyString;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String hello(@RequestParam(value="name", defaultValue="")String name,  Model model) {
        if (isEmptyString(name)){
            return "redirect:/login.html";
        }else {
            List<PublishedMessageDTO> msgList = new ArrayList();
            msgList.add(new PublishedMessageDTO("cloud", "Cloud hosting", "Lorem1 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new PublishedMessageDTO("like", "Logo design", "Lorem2 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new PublishedMessageDTO("dir", "File sharing", "Lorem3 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new PublishedMessageDTO("gallery", "Photography", "Lorem4 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            model.addAttribute("name", name);
            model.addAttribute("msgList", msgList);
            return "index";
        }
    }
}
