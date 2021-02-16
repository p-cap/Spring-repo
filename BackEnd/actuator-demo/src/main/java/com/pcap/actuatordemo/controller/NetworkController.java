package com.pcap.actuatordemo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.pcap.actuatordemo.model.Network;
import com.pcap.actuatordemo.service.INetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class NetworkController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private INetworkService networkService;

    @GetMapping("/test")
    @ResponseBody
    public List<Network> test(Model model) {

        var networks = (List<Network>) networkService.findAll();

        model.addAttribute("networks", networks);

        return networks;
    }

}


