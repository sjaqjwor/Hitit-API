package me.hitit.api.controllers.responses.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.res.Strings;
import me.hitit.api.view_objects.GetUserViewObject;
import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * GetUserResponseData class.
 * 
 * @author devetude
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponseData {
	private static final Logger LOG = Logger.getLogger(GetUserResponseData.class.getSimpleName());

	private Long idx;
	private String name;
	private String email;
	private String profileImageKey;
	private Status status;
	private String msg;

    @JsonIgnore
    public Status getStatus(){
        return this.status;
    }
    @JsonIgnore
    public String getMsg(){
        return this.msg;
    }

	public static GetUserResponseData ofCreate(GetUserViewObject guvo){
		return builder()
				.idx(guvo.getIdx())
				.name(guvo.getName())
				.email(guvo.getEmail())
				.profileImageKey(guvo.getProfileImageKey())
				.status(guvo.getIdx()==null ? Status.NOT_FOUND : Status.SUCCESS)
				.msg(guvo.getIdx()==null? Strings.CAN_NOT_FOUND_USER:null)
				.build()
				;
	}
}