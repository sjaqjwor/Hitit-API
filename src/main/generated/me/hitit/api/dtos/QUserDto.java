package me.hitit.api.dtos;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * me.hitit.api.dtos.QUserDto is a Querydsl Projection type for UserDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QUserDto extends ConstructorExpression<UserDto> {

    private static final long serialVersionUID = 139126996L;

    public QUserDto(com.querydsl.core.types.Expression<Long> idx, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> profileImageKey, com.querydsl.core.types.Expression<String> email) {
        super(UserDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, idx, name, profileImageKey, email);
    }

}

