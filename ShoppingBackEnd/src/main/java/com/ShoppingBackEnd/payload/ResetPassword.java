package com.ShoppingBackEnd.payload;

import javax.validation.constraints.NotBlank;

public class ResetPassword {
	@NotBlank
	private String newPassword;
	@NotBlank
	private String  confirmationToken;
	
	public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

}
