package com.npickard.testejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Friend;

/**
 * Session Bean implementation class FriendEJB
 */
@Stateless
@LocalBean
public class FriendEJB {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FriendEJB() {
        // TODO Auto-generated constructor stub
    }

    public List<Friend> getFriendList(){
    	return em.createQuery("select f from Friend f").getResultList();
    }
    
    public String getFriendName(int id){
    	Friend f = (Friend)getFriendList().get(id);
    	return f.getName();
    }
}
