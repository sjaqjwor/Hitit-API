package me.hitit.api.utils.querydsls;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public class SearchKeyword {
    @NonNull
    String keyword;

    public SearchKeyword(String keyword) {
        this.keyword = keyword;
    }

    public StringExpression getSearchKeyword(String keyword) {
        return Expressions.asString("%").concat(keyword).concat("%");
    }
}
