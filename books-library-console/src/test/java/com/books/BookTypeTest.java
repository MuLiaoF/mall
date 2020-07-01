package com.books;

import com.books.bookManage.mapper.BookTypeMapper;
import com.books.entity.booktype.BookTypeBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookTypeTest
 * @Description 图书类型表测试
 */
@SpringBootTest(classes = BooksLibraryConsoleApplication.class)
@RunWith(SpringRunner.class)
public class BookTypeTest {

    @Autowired(required = false)
    BookTypeMapper mapper;
    @Test
    public void insertTest(){
        BookTypeBean bean = new BookTypeBean();
        bean.setPid(1);
        bean.setTypeName("教育类");
        bean.setIsdel("0");
        bean.setStatus("0");
        mapper.addOneBookType(bean);
        //BookTypeBean bean1 = mapper.selectById(1);
        //System.out.println(bean1);
    }


    @Test
    public void deleteTest(){
       mapper.deleteBookTypeById(1);
    }
}
