package me.hitit.api.controllers.responses.data.user;

import lombok.Builder;
import lombok.Data;
import org.apache.log4j.Logger;

@Data
@Builder
public class UserResponseData {
    private static final Logger LOG = Logger.getLogger(UserResponseData.class);

    private Long idx;
    private String name;
    private String email;
    private String profileImageKey;

}
