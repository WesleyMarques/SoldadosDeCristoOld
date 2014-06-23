package testing.sc;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class testaData {

	@Test
	public void deveTerArquivoELer() {
            File file = new File("src/org/sc/archives/UserLoginOff.dat");
            assertTrue(file.exists());
            assertTrue(file.canRead());
        }
	
	
	

}
