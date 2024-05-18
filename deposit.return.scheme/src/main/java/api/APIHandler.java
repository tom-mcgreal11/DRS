package api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entities.Deposit;
import repositories.DepositRepository;

@RestController
@RequestMapping("/api/")
public class APIHandler{
	
	//CRUD
	
	@Autowired
	private DepositRepository deposit;
	
	//R
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Deposit> getAll() {
		return this.deposit.findAll();
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Deposit> get(@PathVariable("id") Integer id){
		return this.deposit.findById(id);
	}
	
	
	@GetMapping("/get/filter={search}")
	@ResponseStatus(HttpStatus.OK)
	public void getFilter(@PathVariable("search") String search) {
		
	}
	
	
	//CU
	@PostMapping("/deposit/{deposit}")
	@ResponseStatus(HttpStatus.OK)
	public void addDeposit(@PathVariable("deposit") String depositInfo) {
		String[] depositList = depositInfo.split(",");
		System.out.println(depositList[0]);
		Deposit deposit = new Deposit(Integer.parseInt(depositList[0]), depositList[1]);	
		this.deposit.save(deposit);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteDepositById(@PathVariable("id") int id) {
		this.deposit.deleteById(id);
	}
	/*
	 * @PostMapping("")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public void updateDeposit() {
	 * 
	 * }
	 */
}

