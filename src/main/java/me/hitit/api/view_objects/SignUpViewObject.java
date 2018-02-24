package me.hitit.api.view_objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.controllers.responses.data.GetUserResponseData;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpViewObject {
    private static final Logger LOG = Logger.getLogger(SignUpViewObject.class.getSimpleName());

    private Status status;
    private String msg;
    private Boolean enrollment;

    @JsonIgnore
    public Status getStatus(){
        return this.status  ;
    }
    @JsonIgnore
    public String getMsg(){
        return this.msg;
    }
}
