package com.supplier.accounting.repository;

import com.supplier.accounting.entities.MerchantAccount;
import com.supplier.accounting.entities.PeriodWiseMerchantIdentifier;
import org.springframework.data.repository.CrudRepository;

public interface MerchantAccountRepository extends CrudRepository<MerchantAccount, PeriodWiseMerchantIdentifier> {

}
