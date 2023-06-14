package com.ssp.closet.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssp.closet.dto.Account;

@Mapper
public interface AccountMapper {

	Account getAccountByUsername(String userid);

	@Select("SELECT USERID, PASSWORD, EMAIL, USERNAME, ADDRESS, PHONE, RATING"
			+ " FROM ACCOUNT WHERE USERID = #{userId}"
			+ " AND PASSWORD = #{password}")
	Account getAccountByUserIdAndPassword(String userId, String password);
	
	@Insert("INSERT INTO ACCOUNT (USERID, PASSWORD, EMAIL, NAME, ADDRESS, PHONE, RATING)"
			+ " VALUES ({userid}, #{password}, #{email}, #{name}, #{address}, #{phone}, #{rating}")
	int  insertAccount(Account account);
	
	@Insert("UPDATE ACCOUNT SET USERID = #{userid}, PASSWORD = #{password}, "
			+ "EMAIL = #{email}, NAME = #{name}, ADDRESS = #{address}, "
			+ "PHONE = #{phone}, RATING = #{rating}")
	int  updateAccount(Account account);

	@Delete("DELETE FROM ACCOUNT WHERE USERID = #{userid}")
	int  removeAccount(String userid);

	@Select("SELECT USERID FROM ACCOUNT WHERE ACCOUNT.USERID = #{userid}")
	int  exisingUser(String userid);	
	
	@Update("UPDATE ACCOUNT set MILEAGE = MILEAGE - #{mileage} WHERE USERID = #{userId}")
	int  useMileage(int mileage, String userId);
	
	@Update("UPDATE ACCOUNT set MILEAGE = MILEAGE + #{mileage} WHERE USERID = #{userId}")
	int  getMileage(int mileage, String userId);

}