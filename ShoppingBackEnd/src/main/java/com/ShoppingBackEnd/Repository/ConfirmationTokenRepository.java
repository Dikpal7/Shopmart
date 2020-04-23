package com.ShoppingBackEnd.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ShoppingBackEnd.Model.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
