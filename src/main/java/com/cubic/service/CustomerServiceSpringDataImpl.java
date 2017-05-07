package com.cubic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;
import com.cubic.vo.CustomerVO;


@Service
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private CustomerMapper mapper;
	
	public CustomerVO save(final CustomerVO vo) {
		CustomerEntity entity=null;
		
		if(vo.getPk()==null){
			entity=mapper.mapToCustomerEntity(vo);
			
		}else{
			entity=repo.findOne(vo.getPk());
			entity=mapper.mapToCustomerEntity(entity,vo);
		}
		
		
		repo.save(entity);
		//em.persist(entity);
		vo.setPk(entity.getPk());
		return vo;
	}

	
	
	public List<CustomerVO> search(String name) {
	
		//if(StringUtils.isEmpty(name)||name.trim().length()<4)
			
			//List<CustomerEntity> entities = null;
			
			String queryParam=name.trim()+"%";
		/*	TypedQuery<CustomerEntity> query=em.createNamedQuery("CustomerEntity.search",CustomerEntity.class);
			
			query.setParameter("p1", queryParam);
			query.setParameter("p2", queryParam);
			entities=query.getResultList();*/
		return mapper.mapToCustomerVOList(repo.searchCustomers(queryParam));
	}

	
	
	public void remove(Long pk) {
	
		repo.delete(pk);
	}

	
	
	public CustomerVO findCustomer(Long pk) {
		CustomerEntity entity=repo.findOne(pk);
		
		return mapper.mapToCustomerVO(entity);
		
	}

}