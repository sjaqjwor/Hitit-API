package me.hitit.api.services;

import lombok.NonNull;
import me.hitit.api.controllers.responses.data.friend.BlockFriendsResponseData;
import me.hitit.api.controllers.responses.data.friend.FriendResponseData;
import me.hitit.api.domains.Friend;
import me.hitit.api.dtos.FriendDto;
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
    public List<FriendResponseData> getFindFriends(Long tuidx, String sort, Long page, String keyword) {
        List<Friend> friends = fr.getFindFriends(tuidx, sort.split(","), page, keyword);
        int index = 0;
        ModelMapper mm = new ModelMapper();
        List<FriendDto> friendDto = mm.map(friends, new TypeToken<List<FriendDto>>() {
        }.getType());
        for (Friend f : friends) {
            Friend friend = friends.get(index);
            FriendDto fdto = friendDto.get(index);
            fdto.setFuidx(friend.getFriendPk().getFriendUser().getIdx());
            fdto.setName(friend.getFriendPk().getFriendUser().getName());
            fdto.setEmail(friend.getFriendPk().getFriendUser().getEmail());
            fdto.setPhoneNumber(friend.getFriendPk().getFriendUser().getPhoneNumber());
            fdto.setIsBlock(friend.getIsBlock());
            index++;
        }
        List<FriendResponseData> frds = friendDto.stream().map(f -> FriendResponseData.builder()
                .fuidx(f.getFuidx())
                .email(f.getEmail())
                .name(f.getName())
                .phoneNumber(f.getPhoneNumber())
                .build())
                .collect(Collectors.toList());
        return frds;
    }

    @Override
    public void updateFriendBlock(Long tuidx, Long fuidx, Boolean changeBlock) {
        Friend f = fr.updateFriend(tuidx, fuidx);
        if (f.getIsBlock()) {
            changeBlock = false;
            f.setIsBlock(changeBlock);
        } else if (!f.getIsBlock()) {
            changeBlock = true;
            f.setIsBlock(changeBlock);
        }
        fr.save(f);
    }

    @Override
    public List<FriendResponseData> getFriends(Long tuidx, String sort, Long page) {
        List<Friend> friends = fr.getFriends(tuidx, sort.split(","), page);
        int index = 0;
        ModelMapper mm = new ModelMapper();
        List<FriendDto> friendDto = mm.map(friends, new TypeToken<List<FriendDto>>() {
        }.getType());
        for (Friend f : friends) {
            Friend friend = friends.get(index);
            FriendDto fdto = friendDto.get(index);
            fdto.setFuidx(friend.getFriendPk().getFriendUser().getIdx());
            fdto.setName(friend.getFriendPk().getFriendUser().getName());
            fdto.setEmail(friend.getFriendPk().getFriendUser().getEmail());
            fdto.setPhoneNumber(friend.getFriendPk().getFriendUser().getPhoneNumber());
            fdto.setIsBlock(friend.getIsBlock());
            index++;
        }
        List<FriendResponseData> frds = friendDto.stream().map(f -> FriendResponseData.builder()
                .fuidx(f.getFuidx())
                .email(f.getEmail())
                .name(f.getName())
                .phoneNumber(f.getPhoneNumber())
                .build())
                .collect(Collectors.toList());
        return frds;
    }

    @Override
    public List<BlockFriendsResponseData> getBlockFriends(Long tuidx, String sort, Long page) {
        List<Friend> friends = fr.getFriends(tuidx, sort.split(","), page);
        int index = 0;
        ModelMapper mm = new ModelMapper();
        List<FriendDto> friendDto = mm.map(friends, new TypeToken<List<FriendDto>>() {
        }.getType());
        for (Friend f : friends) {
            Friend friend = friends.get(index);
            FriendDto fdto = friendDto.get(index);
            fdto.setFuidx(friend.getFriendPk().getFriendUser().getIdx());
            fdto.setName(friend.getFriendPk().getFriendUser().getName());
            fdto.setEmail(friend.getFriendPk().getFriendUser().getEmail());
            fdto.setPhoneNumber(friend.getFriendPk().getFriendUser().getPhoneNumber());
            fdto.setIsBlock(friend.getIsBlock());
            index++;
        }
        List<BlockFriendsResponseData> bfrds = friendDto.stream().map(f -> BlockFriendsResponseData.builder()
                .fuidx(f.getFuidx())
                .email(f.getEmail())
                .name(f.getName())
                .phoneNumber(f.getPhoneNumber())
                .build())
                .collect(Collectors.toList());
        return bfrds;
    }
}
