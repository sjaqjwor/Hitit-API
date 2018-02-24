package me.hitit.api.view_objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.User;
import org.apache.log4j.Logger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserViewObject {
    private static final Logger LOG = Logger.getLogger(UpdateUserViewObject.class.getSimpleName());

    private Long idx;
    private String name;
    private String email;
    private String profileImageKey;
    private String phonenumber;

    public static UpdateUserViewObject ofCreate(User u) {
        if (u != null) {
            return builder()
                    .idx(u.getIdx())
                    .name(u.getName())
                    .email(u.getEmail())
                    .phonenumber(u.getPhoneNumber())
                    .profileImageKey(u.getProfileImageKey())
                    .build();
        } else {
            return builder().build();
        }
    }
}
