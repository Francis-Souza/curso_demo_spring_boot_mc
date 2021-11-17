package com.joinsolutions.curso_demo_spring_boot_mc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Categoria;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Produto;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.CategoriaRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private OrderRepository orderRepository;
	
	
	
//	
//	@Autowired
//	private OrderItemRepository orderItemRepository;

	
	@Override
	public void run(String... args) throws Exception {

//		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
//		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
//		
//		
//		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
//		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
//		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
//		

		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		Categoria cat4 = new Categoria(null, "Tvs");
		Categoria cat5 = new Categoria(null, "Instrumentos Musicais");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
		
		Produto p1 = new Produto(null,"Impressosa HP",1190.5);
		Produto p2 = new Produto(null,"Smart TV 46 polegadas", 3190.0);
		Produto p3 = new Produto(null,"Macbook Pro", 2250.0);
		Produto p4 = new Produto(null,"Mouse 80", 200.0);
		Produto p5 = new Produto(null,"Violão Acústico", 3400.99);
		Produto p6 = new Produto(null,"NoteBook DHEll", 6500.99);
		Produto p7 = new Produto(null,"Game Of Thones", 500.00);
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		
		
		//Adicionando Categories for Products
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat4);		
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat1);
		p5.getCategorias().add(cat5);
		p6.getCategorias().add(cat3);
		p7.getCategorias().add(cat2);
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		
		
//		userRepository.saveAll(Arrays.asList(u1, u2));
//		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
//		
//		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
//		OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
//		OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
//		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());	 
//		
//		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
//				
//		/* Pagamente de uma ordem */
//		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
//		o1.setPayment(pay1);
//		orderRepository.save(o1);

	}

}
