package com.suy.dao;

import com.suy.pojo.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AddressBookMapper {
    @Select("select * from address_book")
    List<AddressBook> getAddressBook();

    @Select("select * from address_book where id = #{id}")
    AddressBook getAddressBookById(int id);

    @Insert("insert into address_book (id, name, number, server) values (#{id}, #{name}, #{number}, #{server})")
    int insertAddressBook(AddressBook addressBook);

    @Update("update address_book set number = #{number} where id = #{id}")
    int updateAddressBookNumberById(@Param("id") int id, @Param("number") String number);

    @Update("update address_book set number = #{number} where name = #{name}")
    int updateAddressBookNumberByName(@Param("name") String name, @Param("number") String number);

    @Delete("delete from address_book where id = #{id}")
    int deleteAddressBookById(int id);

    @Delete("delete from address_book where name = #{name}")
    int deleteAddressBookByName(String name);

}
