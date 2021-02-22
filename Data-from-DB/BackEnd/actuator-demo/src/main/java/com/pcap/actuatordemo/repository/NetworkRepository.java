package com.pcap.actuatordemo.repository;

import com.pcap.actuatordemo.model.Network;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends CrudRepository<Network,Long>{

}
