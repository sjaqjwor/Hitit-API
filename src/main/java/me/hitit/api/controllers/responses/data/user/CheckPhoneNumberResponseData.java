package me.hitit.api.controllers.responses.data.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import me.hitit.api.utils.res.Strings;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckPhoneNumberResponseData {
    private static final Logger LOG = Logger.getLogger(CheckPhoneNumberResponseData.class.getSimpleName());

    Boolean exist;

}