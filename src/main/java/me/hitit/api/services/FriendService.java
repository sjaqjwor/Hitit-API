package me.hitit.api.services;

import me.hitit.api.domains.Friend;
import me.hitit.api.repositories.FriendRepository;
import me.hitit.api.services.interfaces.FriendServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FriendService")
public class FriendService implements FriendServiceInterface {
    @Autowired
    private FriendRepository fr;

    @Override
    public void addFriend(final Friend f) {
        fr.save(f);
    }
}
