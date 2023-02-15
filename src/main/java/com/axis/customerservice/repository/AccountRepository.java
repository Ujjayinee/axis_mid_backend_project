package com.axis.customerservice.repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.axis.customerservice.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

	@Modifying
	@Query("update Account set accountType=?1,accountBalance=?2 where accountNo=?3")
	void updateAccount(String accountType, double accountBalance,long accountNumber);
}
