package com.javahongkong.bootcamp.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Account implementation for commercial (business) customers.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin,
			double startingDeposit) {
		super(company, accountNumber, pin, startingDeposit);
		// complete the function
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in
	 *         {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		// complete the function
		// for (Person p : authorizedUsers) {
		// 	if (p.getidNumber() == (person.getidNumber()))
		// 		return true;
		// 	break;
		// }
		// return false;
		return authorizedUsers.contains(person);
	}
}
