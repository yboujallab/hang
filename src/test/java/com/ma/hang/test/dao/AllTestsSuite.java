package com.ma.hang.test.dao;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestProfilsDao.class,
   TestProfilsService.class,
   TestStoresDao.class,
   TestUsersDao.class,
   TestUserService.class
})
public class AllTestsSuite {

}
