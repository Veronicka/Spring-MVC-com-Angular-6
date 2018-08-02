package br.com.timelinecrud.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.timelinecrud.model.Usuario;
import br.com.timelinecrud.repository.UsuarioRepository;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
public class UsuarioControllerTest extends TestCase{
	
	private MockMvc mockMvc;
	
	@InjectMocks
	@Autowired
	private UsuarioController usuarioController;
	
	@Mock
    private UsuarioRepository usuarioRepo;
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@After
    public void tearDown() {
    	Mockito.reset(usuarioRepo);
    }
	
	@Test
	public void getAll() throws Exception{
		List<Usuario> list = new ArrayList<Usuario>();
		Usuario u1 = new Usuario(1L, "test1", "123", "teste@teste.com", "1234");
		Usuario u2 = new Usuario(2L, "test2", "1234", "teste2@teste.com", "1234");
		list.add(u1);
		list.add(u2);

		when(usuarioRepo.findAll()).thenReturn((List<Usuario>) list);
				
		mockMvc.perform(get("/getAll"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)));
		}	
		
	@Test
	public void getByName() throws Exception{
		Usuario u1 = new Usuario(1L, "teste", "123", "teste@teste.com", "1234");
		when(usuarioRepo.findByNome("teste")).thenReturn(u1);
				
		mockMvc.perform(get("/getByName?nome=teste"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nome").value("teste"));
		}

}
