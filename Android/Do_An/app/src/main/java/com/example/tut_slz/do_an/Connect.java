package com.example.tut_slz.do_an;

import android.os.AsyncTask;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
/**
 * Created by tut_slz on 11/4/14.
 */
public class Connect extends AsyncTask<Void ,Void,Item> {


    @Override
    protected Item doInBackground(Void... params) {

        try {

            final String url = "http://192.168.1.30:6515/app/rest/item/1"; // Ong them cai url server cua ong vao nhe (trong code no cho la http://rest-service.guides.spring.io/greeting )
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Item item =restTemplate.getForObject(url,Item.class);
            return item;
        }
        catch (Exception e)
        {}
        return null;
    }
}
