package br.smc.banking.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Bean representing an {@link Account} owner.
 *
 * Created by Sidney de Moraes.
 */
@Data
public class Owner {

	private String name;


	public Owner (String name) {

		if (StringUtils.isBlank(name))
			throw new IllegalArgumentException("An owner's name must be provided");

		this.name = name;
	}
}
