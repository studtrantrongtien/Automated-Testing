package lab3;


import org.junit.Test;

import lab3.pages.User;
import static org.hamcrest.Matchers.equalTo;

public class PostTest extends TestBase{
	
	@Test
	public void testReqRegisterSuccess() {
		User dataUser = new User("eve.holt@reqres.in", "pistol");
		request.body(dataUser).post("/api/register").
			then().
				assertThat().
					statusCode(200).
					and().
					body("id", equalTo(4)).
					body("token", equalTo("QpwL5tke4Pnpja7X4"));
	}

	@Test
	public void testReqRegisterFailed() {
		User dataUser = new User("sydney@fife");
		request.body(dataUser).post("/api/register").
		then().
			assertThat().statusCode(400);
	}

}
