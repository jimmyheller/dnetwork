package com.dnetwork.dnetwork;

import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserAuthenticationDetail;
import com.dnetwork.domain.DNetUserAuthenticationDetailRepository;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.OAuthService;
import com.dnetwork.service.impl.OAuthServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.security.Principal;

@RunWith(SpringRunner.class)
public class OAuthServiceImplTest {

    @Mock
    private DNetUserRepository dNetUserRepository;

    @Mock
    private DNetUserAuthenticationDetailRepository dNetUserAuthenticationDetailRepository;


    private OAuthService oAuthService ;

    @Before
    public void setUp() {
        oAuthService = new OAuthServiceImpl(dNetUserRepository,dNetUserAuthenticationDetailRepository);
        DNetUser testUser = new DNetUser
                ("testdnetuser@gmail.com"
                        ,"test user"
                        ,"test"
                        ,"test"
                        ,"https://lh5.googleusercontent.com/-fszuJiu4q2c/AAAAAAAAAAI/AAAAAAAAAAA/ACHi3re88y26O1l4DwbuQhBq0QP9S7UMbw/photo.jpg"
                        ,"fa"
                        ,"105796927116057436597"
                        ,"GMAIL");
        DNetUserAuthenticationDetail dNetUserAuthenticationDetail = new DNetUserAuthenticationDetail
                (
                        "0:0:0:0:0:0:0:1"
                        ,"9FEAEB12A7B7911E7AD30F0F93C12A32"
                        ,"Bearer"
                        ,"ya29.GltrB5ANIzp3TALmqHFKQQP0CBjVRLuO1tsLxr2fhDyBZrSu0SC2LBGitl6zItQIFmZTwAvGNIxZi_S7j-9FsBuACFBEibNCbt7pnhGDxkFmC9JYbiv9TJOLdC8T"
                        ,"5d5d0eeeb5c37f1f50408bee"
                );


//        Mockito.when(mockPrincipal.getName()).thenReturn("me");
        Mockito.when(dNetUserRepository.save(testUser)).thenReturn(testUser);
        Mockito.when(dNetUserAuthenticationDetailRepository.save(dNetUserAuthenticationDetail)).thenReturn(dNetUserAuthenticationDetail);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
//        DNetUser dNetUserTest = oAuthService.registerAsUser( principal);
//        Assertions.assertThat(dNetUserTest)
//                .isEqualTo(dNetUserActual);
    }
}
