/*
package com.tarazgroup.tws.controller.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 *//*

@RestController
@RequestMapping("config")

@Api(tags = "ApllicationConfig",description = " ")
public class ApplicationConfig {

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> validateApplicationKey(){
        try {
            JSONPObject applicationKey = validate();
        */
/*    return Response.
                    status(Response.Status.OK).
                    entity(applicationKey.toString()).
                    build();*//*

        return ResponseEntity.ok( )

        } catch (ApplicationKeyNotValidException e) {
            return PubExceptionHandler.NO_CONTENT("NO_CONTENT", "Your Application Key has Either Corrupted or Removed.");
        } catch (Exception e) {
            return PubExceptionHandler.INTERNAL_SERVER_EXCEPTION("INTERNAL_SERVER_EXCEPTION", "Server Exception");
        }
    }


    private JSONObject validate() throws ApplicationKeyNotValidException, ParseException {
        JSONObject resultJSONObject = new JSONObject();
        JSONObject jsonObject;
        try {
            BufferedReader brTest = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/config/config.config")));
            String firstLine = brTest.readLine();
            jsonObject = TJSON.readJSONObjectString(TZip.base64ToString(TCipher.decrypt(firstLine, "XesMmAR4SdRiqexd", "OdHsrQWtJIRxhKJi")));
        } catch (Exception e) {
            throw new ApplicationKeyNotValidException("The Application Key Is Not Valid.");
        }
        resultJSONObject.put("company_name", jsonObject.get("company_name"));
        JSONArray jSONArrayApplications = (JSONArray) jsonObject.get("applications");
        JSONArray jsonArray = new JSONArray();

        if (jSONArrayApplications == null)
            throw new ApplicationKeyNotValidException("The Application Key Is Not Valid.");

        for (Object jSONObjectApplication : jSONArrayApplications) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(((JSONObject) jSONObjectApplication).get("create_date").toString());
            boolean flag = compareTimeStamp(new Timestamp(parsedDate.getTime()), Integer.parseInt(((JSONObject) jSONObjectApplication).get("valid_day").toString()));
            if (flag) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("application_name", (((JSONObject) jSONObjectApplication).get("application_name").toString().toLowerCase()));
                jsonArray.add(jsonObject1);
            }
        }

        resultJSONObject.put("active_applications", jsonArray);
        return resultJSONObject;
    }

}

*/
