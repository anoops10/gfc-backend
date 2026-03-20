package com.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.AddClientDto;
import com.kfc.pojo.ClientData;
import com.kfc.services.ClientDataServiceClass;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/client")
public class ClientController {

//	@Autowired
	private ClientDataServiceClass service;
	
	
	
	public ClientController(ClientDataServiceClass service) {
	super();
	this.service = service;
}

	@PostMapping("/add/{tId}")
	public ClientData addClientData(@Valid @RequestBody AddClientDto client, @PathVariable int tId) {
		return service.addClient(client.getUser(),
				tId,
				client.getUmem());
	}
	
	@GetMapping("/findall")
	public List<ClientData> allClientList(){
		return service.clientList();
	}
	
	@GetMapping("/findbyuid/{uId}")
	public ClientData findClientByUid(@PathVariable int uId) {
		return service.findClientByUId(uId);
	}
	
	@GetMapping("/findbytid/{tId}")
	public List<ClientData> findByTid(@PathVariable int tId){
	return service.findClientByTId( tId);
	}
	
	@GetMapping("/findbyid/{clientId}")
	public ClientData findClientById(@PathVariable int clientId) {
		return service.findClientById(clientId);
	};

	@PutMapping("/update/{clientId}")
	public ClientData updateClientData(@PathVariable int clientId, @Valid @RequestBody ClientData client) {
		return service.updateClientData(clientId, client);
	};
	
	@DeleteMapping("/delete/{clientId}")
	public String deleteClientData(@PathVariable int clientId) {
		return service.deleteClientData(clientId);
	};
}
