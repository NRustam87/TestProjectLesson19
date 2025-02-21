package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String passowrd;
    String username;
}
