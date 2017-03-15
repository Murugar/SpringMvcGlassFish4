
package com.iqmsoft.glassfish4.spring.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
        
        /**
         * Request access
         * curl -v -X GET -H "Content-Type: application/json" 'http://localhost:8080/springmvcrest/oauth/token?username=user1&password=user1&client_id=client1&client_secret=client1&grant_type=password'\
         * 
         * Request To access protected resource getMyInfo:
         * curl -H "Authorization:Bearer 6fd0f4b7-ca03-49ff-ae46-eea5e6929325"  "http://localhost:8080/springmvcrest/api/getMyInfo"
         * 
         * Request To logout
         * curl -H "Authorization:Bearer 6fd0f4b7-ca03-49ff-ae46-eea5e6929325"  "http://localhost:8080/springmvcrest/api/logou"
         * 
         */
        System.out.println("client: "+clientId);
        if(clientId.equals("client1")) {
            System.out.println("In client: "+clientId);
            
            List<String> authorizedGrantTypes = new ArrayList<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");
            
            Collection<String> col = new ArrayList<>();
            col.add("client1");
            
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId("client1");
            clientDetails.setClientSecret("client1");
            clientDetails.setScope(col);
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

            return clientDetails;

        } else if (clientId.equals("client2")) {
            System.out.println("In client: "+clientId);
            
            List<String> authorizedGrantTypes = new ArrayList<>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");

            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId("client2");
            clientDetails.setClientSecret("client2");
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

            return clientDetails;
        } else {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
    }

}
