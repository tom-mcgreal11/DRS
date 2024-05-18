package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Integer> {

}
