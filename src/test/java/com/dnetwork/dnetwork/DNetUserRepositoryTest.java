package com.dnetwork.dnetwork;

import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DNetUserRepositoryTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private DNetUserRepository dNetUserRepository;
    @Test
    public void whenfFindByEmailThenReturnDNetUser() {
        // given
        DNetUser testUser = new DNetUser
                ("testUser@gmail.com"
                 ,"test user"
                 ,"test"
                 ,"test"
                 ,"https://lh5.googleusercontent.com/-fszuJiu4q2c/AAAAAAAAAAI/AAAAAAAAAAA/ACHi3re88y26O1l4DwbuQhBq0QP9S7UMbw/photo.jpg"
                 ,"fa"
                 ,"105796927116057436597"
                 ,"GMAIL");
        mongoTemplate.save(testUser);

        // when
        DNetUser found = dNetUserRepository.findByEmail(testUser.getEmail());

        // then
        Assertions.assertThat(found.getEmail())
                .isEqualTo(testUser.getEmail());

    }
}
