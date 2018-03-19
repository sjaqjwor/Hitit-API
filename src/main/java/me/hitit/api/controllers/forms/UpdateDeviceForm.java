package me.hitit.api.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import me.hitit.api.domains.Device.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeviceForm {
    @NonNull
    private Type type;
    @NonNull
    private String uuid;
    @NonNull
    private String token;
}
