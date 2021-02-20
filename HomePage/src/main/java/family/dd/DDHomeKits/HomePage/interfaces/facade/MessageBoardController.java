package family.dd.DDHomeKits.HomePage.interfaces.facade;

import family.dd.DDHomeKits.HomePage.application.service.MessageBoardService;
import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageBoardController {
    private MessageBoardService messageBoardService;

    @Autowired
    public void setMessageBoardService(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @ResponseBody
    @PostMapping("/MessageBoardService/publish")
    public String publish(@RequestParam(value="title", defaultValue="No Title")String title,
                        @RequestParam(value="content", defaultValue="Blank")String content){
        messageBoardService.publish(title, content);
        return "1";
    }
}
