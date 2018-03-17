package me.hitit.api.controllers.responses.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@Data
@Builder
public class CheckPhoneNumberResponseData {
    private static final Logger LOG = Logger.getLogger(CheckPhoneNumberResponseData.class.getSimpleName());

    private Boolean exist;

}