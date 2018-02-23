package me.hitit.api.controllers.responses.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.auth.JWT;
import me.hitit.api.utils.res.Strings;
import me.hitit.api.view_objects.GetUserViewObject;
import org.apache.log4j.Logger;

/**
 * SignInResponseData class.
 *
 * @author devetude
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInResponseData {
    private static final Logger LOG = Logger.getLogger(SignInResponseData.class.getSimpleName());

    private String token;
    private Object user;
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

    public static SignInResponseData ofCreate(GetUserViewObject guvo){
        if(guvo.getIdx()==null){
            return builder()
                    .token(null)
                    .user(null)
                    .status(Status.NOT_FOUND)
                    .msg(Strings.CAN_NOT_FOUND_USER)
                    .build();
        }else{
            return builder()
                    .token(JWT.create(guvo.getIdx()))
                    .user(guvo)
                    .status(Status.SUCCESS)
                    .msg(null)
                    .build();
        }
    }
}