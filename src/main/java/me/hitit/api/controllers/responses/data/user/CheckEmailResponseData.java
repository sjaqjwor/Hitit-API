package me.hitit.api.controllers.responses.data.user;

import lombok.*;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckEmailResponseData {
    private static final Logger LOG = Logger.getLogger(CheckEmailResponseData.class.getSimpleName());

    Boolean exist;

}