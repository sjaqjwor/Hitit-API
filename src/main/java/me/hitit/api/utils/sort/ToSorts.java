package me.hitit.api.utils.sort;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimplePath;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import me.hitit.api.domains.QFriend;

@NoArgsConstructor
public class ToSorts {
    @NonNull
    private QFriend qf =QFriend.friend;
    @NonNull
    private OrderSpecifier[] oss;
    @NonNull
    private String[] sorts;

    public ToSorts(String[] sorts) {
        this.sorts = sorts;
        oss = new OrderSpecifier[sorts.length];
    }

    public OrderSpecifier[] getToSorts() {
        int index = 0;
        for(String sort : sorts) {
            Order order = sort.indexOf(0) == '+'
                    ? Order.ASC
                    : Order.DESC;
            SimplePath<Object> sortProperty = Expressions.path(
                    Object.class,
                    qf.friendPk.friendUser,
                    sort.substring(1, sort.length()));
            oss[index] = new OrderSpecifier(order, sortProperty);
            index++;
        }
        return oss;
    }
}
