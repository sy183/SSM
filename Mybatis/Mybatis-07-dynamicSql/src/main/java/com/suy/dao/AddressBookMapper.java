package com.suy.dao;

import com.suy.pojo.AddressBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AddressBookMapper {
    List<AddressBook> getAddressBookIf(Map<String, Object> map);
    List<AddressBook> getAddressBookChoose(@Param("key") String key, @Param("value") Object value);
    List<AddressBook> getAddressBookColumns(@Param("fields") List<String> fields);
    int updateAddressBookById(Map<String, Object> map);
}
