package tacos.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.Order;
import tacos.Taco;
import tacos.data.OrderRepository;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
	private OrderRepository orderRepo;
	
	public OrderController(OrderRepository orderRepo) {
		this.orderRepo =orderRepo;
	}
	
	@GetMapping("/recent")
	public Iterable<Order> recentOrder() {
		return orderRepo.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order postOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
}
