package com.books.member.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.member.Member;

public interface IndexMapper extends BaseMapper<Member> {

    Member select(int i);
}
