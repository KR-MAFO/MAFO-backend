package server.mafobackend.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import server.mafobackend.domain.user.enums.OauthType;
import server.mafobackend.domain.user.enums.RankingType;
import server.mafobackend.domain.user.enums.Role;
import server.mafobackend.global.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 2, max = 12)
    private String nickName;

    // 이메일
    @Length(min = 6, max = 30)
    private String email;

    // 패스워드
    @Length(max = 68)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imageUrl;

    @Length(max = 10)
    @Column(nullable = true)
    private String introduction;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RankingType rankingType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OauthType oauthType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(
            String nickName, String email, String password,
            String imageUrl, RankingType rankingType, OauthType oauthType,
            Role role) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.rankingType = rankingType;
        this.oauthType = oauthType;
        this.role = role;
    }

    public void changeImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void changeIntroduction(String introduction) {this.introduction = introduction;}

    public void changeRankingType(RankingType rankingType) {this.rankingType = rankingType;}

    public void changePassword(String password) {this.password = password;}
}
