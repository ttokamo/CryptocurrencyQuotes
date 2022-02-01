package by.overone.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Component
@Scope("prototype")
@Getter
public class User {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Setter
    private String nickname;

    @Setter
    @Column(name = "crypto_symbol")
    private String cryptoSymbol;

    @Setter
    private String price;
}
