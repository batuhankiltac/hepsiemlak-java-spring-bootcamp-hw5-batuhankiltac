package emlakburada.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Integer id;
    private String name;
    private String email;
    private String bio;
}