package com.myproject;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.dao.UserDAO;
import com.myproject.model.User;
import com.myproject.services.UserService;

public class UserServiceTest {

//	@InjectMocks
//	private UserService userService;
//
//	@BeforeMethod
//	public void initMocks() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	
	@Mock
    private UserDAO userDAO;
    @Mock
    private User user;
    
    @Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMockCreation(){
        assertNotNull(user);
        assertNotNull(userDAO);
    }
    

}
