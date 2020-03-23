package lab3;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import lab3.pages.User;

public class GetTest extends TestBase{
	@Test
	public void testGetListUser() {
		List<User> users = getUsers();
		assertEquals(users.get(0).getEmail(), "michael.lawson@reqres.in");
		assertEquals(users.get(0).getFirst_name(), "Michael");
	}

	@Test
	public void testGetSingleUserNotfound() {
		request.when(). 
			get("api/users/23"). 
		then(). 
			statusCode(404);
	}
	
	
	
	private List<User> getUsers(){
		return request.get("/api/users?page=2").body().jsonPath().getList("data", User.class);
	}
	

}
