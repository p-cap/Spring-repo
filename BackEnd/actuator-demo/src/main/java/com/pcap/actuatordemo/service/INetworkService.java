package com.pcap.actuatordemo.service;

import com.pcap.actuatordemo.model.Network;
import java.util.List;

public interface INetworkService {

    List<Network> findAll();
}
