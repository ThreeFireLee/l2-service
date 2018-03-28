package com.tantan.l2.clients;

import com.tantan.l2.models.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tantan.l2.WxMappingJackson2HttpMessageConverter;

public class MergerClient {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * This method will get a user from id
     * @param id - user id
     * @return
     */

    private final static String url = "http://127.0.0.1:6669/users?search=suggested,scenario-suggested" +
            "&filter=&with=contacts,questions,scenarios,user.publicMoments,relationships&user_id=1&limit=5";

    public Resp getUsers(Long id, String limit, String search, String filter, String with) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        //convert json to java object
        ObjectMapper mapper = new ObjectMapper();
        String usersFromMerger = restTemplate.getForObject(url, String.class);
        Resp userList = null;
        try {
            userList = mapper.readValue(usersFromMerger, Resp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LOGGER.info("usersFromMerger data is :  " + usersFromMerger.toString());
        return userList;


    }
}
