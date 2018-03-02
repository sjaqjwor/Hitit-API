package me.hitit.api.controllers.responses.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

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

    private UserResponseData userResponseData;
}