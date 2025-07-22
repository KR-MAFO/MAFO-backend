package server.mafobackend.domain.user.domain.facade;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import server.mafobackend.domain.user.domain.QUser;
import server.mafobackend.domain.user.domain.User;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {
    private final JPAQueryFactory queryFactory;

    public User getUserByEmail(String email){
        QUser qUser = QUser.user;

        User user = queryFactory
                .selectFrom(qUser)
                .where(qUser.email.eq(email))
                .fetchOne();

        if(user == null){
            log.error("user Not Found email: {}", email);
            throw new IllegalArgumentException("USER_NOT_FOUND");
        }

        return user;
    }

    public boolean existsByEmail(String email){
        QUser qUser = QUser.user;

         return queryFactory
                .selectFrom(qUser)
                .where(qUser.email.eq(email))
                .fetchOne()!= null;
    }
}
