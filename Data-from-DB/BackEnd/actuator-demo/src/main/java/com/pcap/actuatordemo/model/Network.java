package com.pcap.actuatordemo.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "network")
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String IP;
    private String URL;
    private String Useragent;
    private String Domain;

    // what is the one below again????
    public Network() {

    }

    public Network (Long id, String IP, String URL, String Useragent, String Domain) {
        this.id = id;
        this.IP = IP;
        this.URL = URL;
        this.Useragent = Useragent;
        this.Domain = Domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUseragent() {
        return Useragent;
    }

    public void setUseragent(String useragent) {
        Useragent = useragent;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Network other = (Network) obj;
        if (!Objects.equals(this.IP, other.IP)) {
            return false;
        }if (!Objects.equals(this.URL, other.URL)) {
            return false;
        }if (!Objects.equals(this.Useragent, other.Useragent)) {
            return false;
        }
        if (!Objects.equals(this.Domain, other.Domain)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
