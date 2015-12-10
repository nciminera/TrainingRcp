package com.arcad.rental.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class RentalAdapter implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T  getAdapter(Object adaptableObject, Class<T> adapterType) {
		Object result= null;
		if ((adaptableObject instanceof Rental)&& (adapterType == Customer.class)) {
			result =((Rental)adaptableObject).getCustomer();			
		}
		return (T) result;
	}

	@Override
	public Class<?>[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[]{
				Customer.class
		};
	}

}
