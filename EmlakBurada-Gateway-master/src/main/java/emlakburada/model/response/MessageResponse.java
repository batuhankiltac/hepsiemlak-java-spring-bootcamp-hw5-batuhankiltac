package emlakburada.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageResponse {

    private String title;
    private String description;
    private Date sentDate;
    private Date readDate;
    private Boolean isSeen;
}