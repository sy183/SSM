package com.suy.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suy.pojo.AddressBook;
import com.suy.util.MySqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class AddressBookMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();

    @Test
    public void test() {
        try (SqlSession sqlSession = MySqlSessionFactory.openSession(true)) {
            AddressBookMapper mapper = sqlSession.getMapper(AddressBookMapper.class);

            logger.info("select * from address_book");
            List<AddressBook> addressBook = mapper.getAddressBook();
            logger.info(gson.toJson(addressBook));

            logger.info("select * from address_book where id = 2");
            AddressBook address = mapper.getAddressBookById(2);
            logger.info(gson.toJson(address));

            logger.info("insert into address_book (id, name, number, server) values (13, 'WEB端', '1019', '10.16.50.13:5080')");
            int count = mapper.insertAddressBook(new AddressBook(13, "WEB端", "1019", "10.16.50.13:5080"));
            logger.info("添加了%d条记录".formatted(count));

            logger.info("update address_book set number = '1016' where name = 'WEB端'");
            count = mapper.updateAddressBookNumberByName("WEB端", "1016");
            logger.info("更改了%d条记录".formatted(count));

            logger.info("delete from address_book where name = 'WEB端'");
            count = mapper.deleteAddressBookByName("WEB端");
            logger.info("删除了%d条记录".formatted(count));
        }
    }
}