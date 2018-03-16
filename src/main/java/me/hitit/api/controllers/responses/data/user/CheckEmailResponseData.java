package me.hitit.api.controllers.responses.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@Data
@Builder
public class CheckEmailResponseData {
    private static final Logger LOG = Logger.getLogger(CheckEmailResponseData.class.getSimpleName());

    private Boolean exist;

}