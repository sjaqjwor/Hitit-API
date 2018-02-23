package me.hitit.api.controllers.responses.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.res.Strings;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckEmailResponseData {
    private static final Logger LOG = Logger.getLogger(CheckEmailResponseData.class.getSimpleName());

    Boolean exist;
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

    public static CheckEmailResponseData ofCreate(Boolean exist){
        return builder()
                .exist(exist)
                .msg(exist==true ? Strings.ALREADY_EXIST_EMAIL:null)
                .status(exist==true ? Status.CONFLICT: Status.SUCCESS)
                .build();
    }
}
