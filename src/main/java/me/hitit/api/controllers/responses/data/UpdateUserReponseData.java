package me.hitit.api.controllers.responses.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.domains.User;
import me.hitit.api.utils.res.Strings;
import me.hitit.api.view_objects.UpdateUserViewObject;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserReponseData {
    private static final Logger LOG = Logger.getLogger(UpdateUserReponseData.class.getSimpleName());

    private Long idx;
    private String name;
    private String email;
    private String profileImageKey;
    private Status status;
    private String msg;

    @JsonIgnore
    public Status getStatus(){
        return this.status  ;
    }
    @JsonIgnore
    public String getMsg(){
        return this.msg;
    }

    public static UpdateUserReponseData ofCreate(UpdateUserViewObject uuvo){
        return builder()
                .idx(uuvo.getIdx())
                .name(uuvo.getName())
                .email(uuvo.getEmail())
                .profileImageKey(uuvo.getProfileImageKey())
                .status(uuvo.getIdx()==null ? Status.NOT_FOUND:Status.SUCCESS)
                .msg(uuvo.getIdx()==null ? Strings.CAN_NOT_FOUND_USER : null)
                .build();
    }
}
