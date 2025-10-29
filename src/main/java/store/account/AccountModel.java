package store.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "account")
@Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class AccountModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "sha256")
    private String sha256;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public AccountModel(Account a) {
        this.id = a.id();
        this.name = a.name();
        this.email = a.email();
        this.sha256 = a.sha256();
        this.role = a.role();
    }

    public Account to() {
        return Account.builder()
            .id(this.id)
            .name(this.name)
            .email(this.email)
            .sha256(this.sha256)
            .role(this.role)
            .build();
    }
    
}