package me.hitit.api.services;

import lombok.NonNull;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.dtos.FriendDTO;
import me.hitit.api.repositories.FriendRepository;
import me.hitit.api.services.interfaces.FriendServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("FriendService")
public class FriendService implements FriendServiceInterface {
    @NonNull
    @Autowired
    private FriendRepository fr;

    @Override
    public void addFriend(final Friend f) {
        fr.save(f);
    }

    @Override
    public List<Friend> getFriends(Long tuidx, String sort, Long page) {
        return fr.getFriends(tuidx, sort.split(","), page);
    }

    @Override
    public List<Friend> getFindFriends(Long tuidx, String sort, Long page, String keyword) {
        return fr.getFindFriends(tuidx, sort.split(","), page, keyword);
    }

    @Override
    public Friend updateFriendBlock(Long tuidx, Long fuidx, UpdateFriendBlockForm ufbf) {
        Friend f = fr.updateFriend(tuidx, fuidx);
        if (f.getCheckBlock()) {
            ufbf.setCheckBlock(false);
            f.setCheckBlock(ufbf.getCheckBlock());
        } else if (!f.getCheckBlock()) {
            ufbf.setCheckBlock(true);
            f.setCheckBlock(ufbf.getCheckBlock());
        }
        fr.save(f);
        return f;
    }

    @Override
    public List<FriendResponseData> getFriendsDto(Long tuidx, String sort, Long page) {
        List<Friend> friends = fr.getFriends(tuidx, sort.split(","), page);
        ModelMapper mm = new ModelMapper();
        List<FriendDTO> friendDtos = mm.map(friends, new TypeToken<List<FriendDTO>>() {
        }.getType());
        for (int i = 0; i < friends.size(); i++) {
            Friend friend = friends.get(i);
            FriendDTO dto = friendDtos.get(i);
            dto.setFuidx(friend.getFriendPk().getFriendUser().getIdx());
            dto.setName(friend.getFriendPk().getFriendUser().getName());
            dto.setEmail(friend.getFriendPk().getFriendUser().getEmail());
            dto.setPhoneNumber(friend.getFriendPk().getFriendUser().getPhoneNumber());
            dto.setCheckBlock(friend.getCheckBlock());
        }
        List<FriendResponseData> frds = friendDtos.stream().map(f -> FriendResponseData.builder()
                .fuidx(f.getFuidx())
                .email(f.getEmail())
                .name(f.getName())
                .phoneNumber(f.getPhoneNumber())
                .checkBlock(f.getCheckBlock())
                .build())
                .collect(Collectors.toList());
        return frds;
    }
}
