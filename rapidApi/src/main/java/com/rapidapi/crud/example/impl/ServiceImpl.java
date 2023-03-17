package com.rapidapi.crud.example.impl;

import com.google.gson.Gson;
import com.rapidapi.crud.example.Utils.VerifyUtils;
import com.rapidapi.crud.example.dto.ExampleDto;
import com.rapidapi.crud.example.dto.VerifyDto;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceImpl {

    public VerifyDto getVerifyParameter(String phoneNumber) {

        VerifyDto verifyDto = null;

        try {
            URL url = new URL(VerifyUtils.ENDPOINT_URL_VERIFY);
            HttpURLConnection connection = createConnection(url + phoneNumber);
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            Gson gson = new Gson();

            String tokenRequestDtoAsJson = gson.toJson(verifyDto);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(tokenRequestDtoAsJson);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            System.out.println("GET REQUEST VERIFY: " + url);
            System.out.println("GET parameters : " + tokenRequestDtoAsJson);
            System.out.println("Response Code : " + responseCode);

            connection.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return verifyDto;
    }

    public ExampleDto getExampleParameters(String countryCodeAsParameter, String typeAsParameter) {

        ExampleDto exampleDto = null;

        try {
            URL url = new URL(VerifyUtils.ENDPOINT_URL_EXAMPLE);
            HttpURLConnection connection = createConnection(url.toString());
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            Gson gson = new Gson();
            String tokenRequestDtoAsJson = gson.toJson(exampleDto);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(tokenRequestDtoAsJson);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            System.out.println("GET REQUEST EXAMPLE : " + url);
            System.out.println("GET parameters : " + tokenRequestDtoAsJson);
            System.out.println("Response Code : " + responseCode);

            connection.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return exampleDto;
    }

    private HttpURLConnection createConnection(String urlAsStr) {

        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(urlAsStr);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty(VerifyUtils.HEADER_KEY, VerifyUtils.HEADER_KEY_VALUE);
            httpURLConnection.setRequestProperty(VerifyUtils.HEADER_HOST, VerifyUtils.HEADER_HOST_VALUE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return httpURLConnection;
    }

}
