package am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usermedia")
public class UserMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String photoUrl;

    @Column
    private Long user_id;

    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;

}
