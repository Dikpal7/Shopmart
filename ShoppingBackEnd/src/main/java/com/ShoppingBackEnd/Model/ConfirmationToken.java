package com.ShoppingBackEnd.Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ShoppingBackEnd.Model.Audit.DateAudit;

@SuppressWarnings("serial")
@Entity
@Table(name = "ConfirmationToken", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "confirmation_token"
        })
})
public class ConfirmationToken extends DateAudit{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;
    
	
	  @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	  @JoinColumn(nullable = false, name = "id") 
	 private User user;
    

    public ConfirmationToken(User user) {
        this.user = user;
        confirmationToken = UUID.randomUUID().toString();
    }
    public ConfirmationToken() {     
    }
    
    public String getConfirmationToken() {
        return confirmationToken;
    }
    
    public User getUser() {
    	return user;
    }
    
}
