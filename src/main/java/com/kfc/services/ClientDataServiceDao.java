package com.kfc.services;

import java.util.List;

import com.kfc.dto.AddClientDto;
import com.kfc.pojo.ClientData;

public interface ClientDataServiceDao {

	ClientData addClient(int uId, int tId, int umId);
	List<ClientData> clientList();
	ClientData findClientByUId(int uId);
	List<ClientData> findClientByTId(int tId);
	ClientData findClientById(int clientId);
	ClientData updateClientData(int clientId, ClientData client);
	String deleteClientData(int clientId);
	
}
