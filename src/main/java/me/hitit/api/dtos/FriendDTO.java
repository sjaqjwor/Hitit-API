package me.hitit.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendDto {
    private Long fuidx;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isBlock;
}
