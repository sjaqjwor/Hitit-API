package me.hitit.api.dtos;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hitit.api.domains.User;

@Data
@NoArgsConstructor
@Builder
public class UserDto {
	private Long idx;
	private String name;
	private String email;
	private String profileImageKey;

	public static UserDto getUserDto(User u) {
		return builder().idx(u.getIdx()).name(u.getName()).email(u.getEmail()).profileImageKey(u.getProfileImageKey())
				.build();
	}

	@QueryProjection
	public UserDto(Long idx, String name, String email, String profileImageKey) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.profileImageKey = profileImageKey;
	}
}