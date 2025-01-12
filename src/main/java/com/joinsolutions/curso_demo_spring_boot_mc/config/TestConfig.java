package com.joinsolutions.curso_demo_spring_boot_mc.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Categoria;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Cidade;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Cliente;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Endereco;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Estado;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.ItemPedido;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Pagamento;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.PagamentoComBoleto;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.PagamentoComCartao;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Pedido;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.Produto;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.enums.EstadoPagamentoEnum;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.enums.TipoClienteEnum;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.CategoriaRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.CidadeRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ClienteRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.EnderecoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.EstadoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ItemPedidoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.PagamentoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.PedidoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;



	
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


		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		Categoria cat4 = new Categoria(null, "Tvs");
		Categoria cat5 = new Categoria(null, "Instrumentos Musicais");
		Categoria cat6 = new Categoria(null, "Produtos Perecíveis");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5, cat6));
		
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
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Louveira", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@Gmail.com", "151.555.666-53", TipoClienteEnum.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "João Costa e Silva", "joao@Gmail.com", "651.336.966-53", TipoClienteEnum.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Pedro Souza e Silva", "pedro@Gmail.com", "251.445.666-53", TipoClienteEnum.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("143335-2560","215555-9544"));
		cli2.getTelefones().addAll(Arrays.asList("123335-2560","115555-9544"));
		cli3.getTelefones().addAll(Arrays.asList("153335-2560","8515555-9544"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "150", "Apto 301", "Jardim", "38400001", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua Flores Cunha", "300", "Apto 501", "Flores", "39400001", cli2, c2);		
		Endereco end3 = new Endereco(null, "Rua Flores Verdes", "400", "Apto 601", "Palmares", "36400001", cli3, c2);
		Endereco end4 = new Endereco(null, "Rua Ipe Verde", "200", "Apto 101", "Palmares", "36400001", cli3, c3);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		cli2.getEnderecos().addAll(Arrays.asList(end2));
		cli3.getEnderecos().addAll(Arrays.asList(end3,end4));		
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3,end4));
			
		Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), cli1, end1);
		Pedido ped2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), cli1, end2);
		
		
		
		/* Pagamente de uma Pedido */
		Pagamento pag1 = new PagamentoComCartao(null,EstadoPagamentoEnum.QUITADO, ped1, 6);		
		ped1.setPagamento(pag1);
		 
		
		Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamentoEnum.PENDENTE,ped2,null, Instant.parse("2017-10-20T19:53:07Z"));		
		ped2.setPagamento(pag2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p2,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
				
//		/* Pagamente de uma ordem */
//		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
//		o1.setPayment(pay1);
//		orderRepository.save(o1);

	}

}
