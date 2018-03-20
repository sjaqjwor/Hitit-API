package me.hitit.api.services;

import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.domains.Friend;
import me.hitit.api.repositories.FriendRepository;
import me.hitit.api.services.interfaces.FriendServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FriendService")
public class FriendService implements FriendServiceInterface {
    @Autowired
    private FriendRepository fr;

    @Override
    public void addFriend(final Friend f) {
        fr.save(f);
    }

    @Override
    public List<Friend> getFriends(Long tuidx, String sort, Long page) {
        String[] resultSorts = sort.split(",");
        return fr.getFriends(tuidx, resultSorts, page);
    }

    @Override
    public List<Friend> getFindFriends(Long tuidx, String sort, Long page, String keyword) {
        String[] resultSorts = sort.split(",");
        return fr.getFindFriends(tuidx, resultSorts, page, keyword);
    }

    @Override
    public Friend updateFriendBlock(Long tuidx, Long fuidx, UpdateFriendBlockForm ufbf) {
        Friend f = fr.updateFriend(tuidx, fuidx);
        if (f.getCheckBlock() == true) {
            ufbf.setCheckBen(false);
            f.setCheckBlock(ufbf.getCheckBen());
        } else if (f.getCheckBlock() == false) {
            ufbf.setCheckBen(true);
            f.setCheckBlock(ufbf.getCheckBen());
        }
        fr.save(f);
        return f;
    }
}
