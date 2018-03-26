package me.hitit.api.services;

import lombok.NonNull;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.domains.Friend;
import me.hitit.api.repositories.FriendRepository;
import me.hitit.api.services.interfaces.FriendServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
