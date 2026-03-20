package com.kfc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfc.dto.AddClientDto;
import com.kfc.pojo.ClientData;
import com.kfc.pojo.Trainer;
import com.kfc.pojo.UserMembership;
import com.kfc.pojo.Users;
import com.kfc.repository.ClientRepository;

@Service
public class ClientDataServiceClass implements ClientDataServiceDao {
	
	private ClientRepository repo;
	private TrainerServiceClass tService;
	private UserMembershipServiceClass umService;
	private UserServicesClass uService;
	
	
	public ClientDataServiceClass(ClientRepository repo, TrainerServiceClass tService,
			UserMembershipServiceClass umService, UserServicesClass uService) {
		super();
		this.repo = repo;
		this.tService = tService;
		this.umService = umService;
		this.uService = uService;
	}

	@Override
	public ClientData addClient(int uId, int tId, int umId) {
		ClientData newC = new ClientData();
		Users user = uService.getUserById(uId);
		Trainer trainer = tService.getTrainerById(tId);
		UserMembership umem = umService.GetListByUMID(umId);
		newC.setTrainer(trainer);
		newC.setUmem(umem);
		newC.setUser(user);
		return repo.save(newC);
	}

	@Override
	public List<ClientData> clientList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ClientData findClientByUId(int uId) {
		// TODO Auto-generated method stub
		return repo.findByUser_uId(uId).orElse(null);
	}

	@Override
	public List<ClientData> findClientByTId(int tId) {
		// TODO Auto-generated method stub
		return repo.findByTrainer_TId(tId);
	}

	@Override
	public ClientData findClientById(int clientId) {
		// TODO Auto-generated method stub
		return repo.findById(clientId).orElse(null);
	}

	@Override
	public ClientData updateClientData(int clientId, ClientData client) {

		ClientData prevClient = repo.findById(clientId).orElse(null);
//		Trainer T = tService.getTrainerById(tId);
		prevClient.setAge(client.getAge());
		prevClient.setHeight(client.getHeight());
		prevClient.setSchedule(client.getSchedule());
		prevClient.setWeight(client.getWeight());
//		prevClient.setTrainer(T);
		return repo.save(prevClient);
	}

	@Override
	public String deleteClientData(int clientId) {
		
		return "Client data clientId: "+clientId+" is deleted";
	}

}
