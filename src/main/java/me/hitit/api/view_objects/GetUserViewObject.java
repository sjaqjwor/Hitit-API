package me.hitit.api.view_objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.data.GetUserResponseData;
import me.hitit.api.domains.User;
import org.apache.log4j.Logger;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserViewObject {
    private static final Logger LOG = Logger.getLogger(GetUserViewObject.class.getSimpleName());

    private Long idx;
    private String name;
    private String email;
    private String phonenumber;
    private String profileImageKey;


    public static GetUserViewObject getCreate(User u) {
        if (u != null) {
            return builder()
                    .idx(u.getIdx())
                    .email(u.getEmail())
                    .name(u.getName())
                    .phonenumber(u.getPhoneNumber())
                    .profileImageKey(u.getProfileImageKey())
                    .build();
        }else{
            return builder().build();
        }
    }
}
