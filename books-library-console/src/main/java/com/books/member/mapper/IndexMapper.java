package com.books.member.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface IndexMapper extends BaseMapper<Member> {

    Member select(int i);
}
