package com.ShoppingBackEnd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ShoppingBackEnd.Model.ConfirmationToken;

public interface ConfirmationTokenRepo extends CrudRepository<ConfirmationToken, Long> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
