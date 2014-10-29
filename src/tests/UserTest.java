/**
 * 
 */
package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sc.models.PhonesUsers;
import org.sc.models.QuestionnarieUser;
import org.sc.models.User;
import org.sc.models.UserLogin;
import org.sc.models.UserRegistry;
import org.sc.utils.Patentes;

/**
 * @author Ingenico-05
 *
 */
public class UserTest {

	private User user;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void userRegistryTest() {
		user = new UserRegistry(0, "Wesley Nunes Marques Torres", "Marques", 360684, 4, 4, "", "", "", UserRegistry.MAN,
				"", "09692328457", UserRegistry.SINGLE, "Superior - incompleto", "Estudante", "Brasileiro", "Fazer Enum",
				"", "Fernando Marques Torres", "Ilma Nunes Marques", "Rua Manoel do O. Júnior", "300", "", "58415363", "Cruzeiro",
				"Campina Grande", "Paraíba", "Brasil", new PhonesUsers(),"wesley.nmtorres@gmail.com", new QuestionnarieUser());
	}
}
