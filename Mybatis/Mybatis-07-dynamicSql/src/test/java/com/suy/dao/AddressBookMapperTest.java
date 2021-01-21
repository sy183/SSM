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
import java.util.Map;

public class AddressBookMapperTest {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Logger logger = LogManager.getLogger();

    @Test
    @SuppressWarnings("all")
    public void test() {
        try (SqlSession sqlSession = MySqlSessionFactory.openSession(true)) {
            AddressBookMapper mapper = sqlSession.getMapper(AddressBookMapper.class);
            List<AddressBook> addressBook = mapper.getAddressBookIf(gson.fromJson("""
                    {
                        "number": "11",
                        "server": "10.16.50.13"
                    }
                    """, Map.class));
            logger.info(addressBook);

            addressBook = mapper.getAddressBookChoose("number", "7211");
            logger.info(gson.toJson(addressBook));

            logger.info(gson.fromJson("""
                    ["name", "number"]
                    """, List.class));
            addressBook = mapper.getAddressBookColumns(gson.fromJson("""
                    ["name", "number"]
                    """, List.class));
            logger.info(gson.toJson(addressBook));

            mapper.updateAddressBookById(gson.fromJson("""
                    {
                        "id": "1",
                        "number": "82110111"
                    }
                    """, Map.class));
        }
    }
}