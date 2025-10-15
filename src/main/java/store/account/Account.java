package store.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder @Data @Accessors(fluent = true, chain = true)
@Entity
@Table(name = "account", schema = "account")
public class Account {

    @Id
    @Column(name = "id_account")
    private String id;

    @Column(name = "tx_name")
    private String name;

    @Column(name = "tx_email")
    private String email;

    private String password;

    @Column(name = "tx_sha256")
    private String sha256;
    
}