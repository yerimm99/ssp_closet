package com.ssp.closet.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssp.closet.dao.SequenceDao;
import com.ssp.closet.dao.AuctionDao;
import com.ssp.closet.dao.BidDao;
import com.ssp.closet.dto.Auction;

@Repository
public class JpaAuctionDao implements AuctionDao{
	
	@PersistenceContext
    private EntityManager em;
	@Autowired
	private SequenceDao sequenceDao;
//	@Autowired
//	private BidDao bidDao;
	
	public void insertAuction(Auction auction) throws DataAccessException {
		int newProductId = sequenceDao.getNextId("a");
    	auction.setProductId(newProductId);
		em.persist(auction);
	}

	public Auction getAuctionDetail(int productId) throws DataAccessException {
		return em.find(Auction.class, productId);
	}
	
	public void updateMaxPrice(Auction auction) throws DataAccessException {
//		int price = bidDao.findMaxPrice(auction.getProductId());
//		auction.setMaxPrice(price);
//		em.persist(auction);
	}
	
	public List<Auction> getAuctionList() throws DataAccessException {
		TypedQuery<Auction> query = em.createQuery("SELECT g FROM Auction g", Auction.class);
		return query.getResultList();
	}
}
