package family.dd.DDHomeKits.HomePage.interfaces.facade;

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
            List<SrvMsg> msgList = new ArrayList();
            msgList.add(new SrvMsg("cloud", "Cloud hosting", "Lorem1 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new SrvMsg("like", "Logo design", "Lorem2 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new SrvMsg("dir", "File sharing", "Lorem3 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            msgList.add(new SrvMsg("gallery", "Photography", "Lorem4 ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et"));
            model.addAttribute("name", name);
            model.addAttribute("msgList", msgList);
            return "index";
        }
    }

    private class SrvMsg {
        public SrvMsg(String icon, String title, String body) {
            this.title = title;
            this.body = body;
            this.icon = icon;
        }

        private String title;
        private String body;
        private String icon;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
