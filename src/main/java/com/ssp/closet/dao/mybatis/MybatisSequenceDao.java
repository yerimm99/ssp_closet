package com.ssp.closet.dao.mybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.ssp.closet.dao.SequenceDao;
import com.ssp.closet.dao.mybatis.mapper.SequenceMapper;
import com.ssp.closet.dto.Sequence;

@Repository
public class MybatisSequenceDao implements SequenceDao {
	@Autowired
	protected SequenceMapper sequenceMapper;
	
  /**
   * This is a generic sequence ID generator that is based on a database
   * table called 'SEQUENCE', which contains two columns (NAME, NEXTID).
   * This approach should work with any database.
   * @param name the name of the sequence
   * @return the next ID
   */
	public int getNextId(String name) throws DataAccessException {
		Sequence sequence = new Sequence(-1);
	    sequence = (Sequence) sequenceMapper.getSequence(sequence);
	    if (sequence == null) {
	    	throw new DataRetrievalFailureException(
	    		"Error: A null sequence was returned from the database "
	    		+ "(could not get next " + name + " sequence).");
	    }
	    Sequence parameterObject = new Sequence(sequence.getNextId()+1);
	    sequenceMapper.updateSequence(parameterObject);
	    return sequence.getNextId();
	}
}
