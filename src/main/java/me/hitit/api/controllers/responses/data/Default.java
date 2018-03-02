package me.hitit.api.controllers.responses.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.controllers.responses.DefaultResponse.Status;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Default {
    private static final Logger LOG = Logger.getLogger(Default.class.getSimpleName());

    private Long idx;
    private String name;
    private String email;
    private String profileImageKey;
    private Status status;
    private String msg;

}
