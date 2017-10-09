package helpers;

import br.smc.banking.model.Owner;

/**
 * Factory used to create dummy instances for tests.
 *
 * Created by Sidney de Moraes.
 */
public class DummyObjectsFactory {

	public static Owner getDummyOwner() {

		return new Owner("Dummy User");
	}

}
