package family.dd.DDHomeKits.HomePage.domain.MessageBoard.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageBoardMapper {
    @Select("Select msgId, " +
            "title, content, " +
            "author, " +
            "pubDate " +
            "from MessageBoard " +
            "order by msgId desc " +
            "limit #{limit}")
    List<MessageBoardPO> findRecentMessages(int limit);

    @Insert("Insert into MessageBoard(title, " +
            "content, " +
            "author) values (#{title}, " +
            "#{content}, " +
            "#{author})")
    void add(MessageBoardPO messageBoardPO);
}
