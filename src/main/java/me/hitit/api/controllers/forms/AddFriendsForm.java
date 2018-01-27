package me.hitit.api.controllers.forms;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFriendsForm {
	private static final String TAG = AddFriendForm.class.getSimpleName();

	private List<String> phoneNumbers;
}