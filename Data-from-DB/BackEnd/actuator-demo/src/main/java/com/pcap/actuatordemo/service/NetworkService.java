package com.pcap.actuatordemo.service;

import com.pcap.actuatordemo.model.Network;
import com.pcap.actuatordemo.repository.NetworkRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkService implements INetworkService {

    @Autowired
    private NetworkRepository repository;

    @Override
    public List<Network> findAll() {

        var networks = (List<Network>) repository.findAll();

        return networks;
    }
}
