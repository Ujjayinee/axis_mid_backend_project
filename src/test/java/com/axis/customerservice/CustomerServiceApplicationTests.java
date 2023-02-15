package com.axis.customerservice;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.axis.customerservice.controller.AccountController;
import com.axis.customerservice.controller.CustomerController;
import com.axis.customerservice.controller.TransactionController;
import com.axis.customerservice.entity.Account;
import com.axis.customerservice.entity.Customer;
import com.axis.customerservice.entity.Transaction;
import com.axis.customerservice.service.AccountService;
import com.axis.customerservice.service.CustomerService;
import com.axis.customerservice.service.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.axis.customerservice.CustomerServiceApplication.class,
webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerServiceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private AccountService accountService;
	
	@MockBean
	private TransactionService transactionService;

//	@BeforeEach
//	public void setup() {
//		CustomerController customerController = new CustomerController();
//		customerController.setCustomerService(customerService);
//		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
//		
//	}
	
	Customer customer=new Customer(12705, "Pratik", null, "Male", "Indian", 7620121554L, "pratik@gmail.com", "AHFJI7786K", 987528634951L, "Sankalp Colony", "Akot", 444101, "Maharashtra", "123456", null, null);
	Account account=new Account(23568974L, "Saving Account", 17500.0);
	Transaction transaction=new Transaction(123456,null ,23568974L ,"Cash withdraw" ,"Debited" ,2500.0 ,1500.0);
	
	@Test
	public void getCustomerByCustomerIdTest() throws Exception {
		CustomerController customerController = new CustomerController();
		customerController.setCustomerService(customerService);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
		
		Mockito.when(customerService.getCustomerById(Mockito.anyInt())).thenReturn(customer);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/customer/12705").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedCustomer = "{'customerId':12705,'customerName':'Pratik','dateOfBirth':null,'gender':'Male','customerNationality':'Indian','customerMobileNo':7620121554,'customerEmailId':'pratik@gmail.com','customerPanCardNo':'AHFJI7786K','customerAadharCardNo':987528634951,"
				+ "'currentAddress':'Sankalp Colony','city':'Akot','pincode':444101,'state':'Maharashtra','password':'123456','accounts':null,'transactions':null}";
		JSONAssert.assertEquals(expectedCustomer,result.getResponse().getContentAsString() , false);
	}
	
	@Test
	public void getAccountByAccountNumberTest() throws Exception {
		AccountController accountController = new AccountController();
		accountController.setAccountService(accountService);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
		
		Mockito.when(accountService.getAccountByAccountNumber(Mockito.anyLong())).thenReturn(account);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/accounts/23568974").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedAccount = "{'accountNo':23568974,'accountType':'Saving Account','accountBalance':17500.0}";
		JSONAssert.assertEquals(expectedAccount,result.getResponse().getContentAsString() , false);
		
	}
	
	@Test
	public void getTransactionbyTransactionIdTest() throws Exception{
		
		TransactionController transactionController = new TransactionController();
		transactionController.setTransactionService(transactionService);
		mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
		
		Mockito.when(transactionService.getTransactionById(Mockito.anyInt())).thenReturn(transaction);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/transaction/123456").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedTransaction = "{'transactionId':123456,'trasactionDate':null,'accountNo':23568974,'description':'Cash withdraw','transactionType':'Debited','transactedAmount':2500.0,'totalBalance':1500.0}";
		JSONAssert.assertEquals(expectedTransaction,result.getResponse().getContentAsString() , false);
		
	}
	
}
