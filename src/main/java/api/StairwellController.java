package api;

import Models.Stairwell;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StairwellController {

    /*
    * GET: http://localhost:8080/api/stairwell/12,13,19/3
    * flights array in the URI must be separated by a comma otherwise it is a bad request 400
    **/
    @GetMapping(path = "/stairwell/{flights}/{strides}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity calculateAnswer(
            @PathVariable("flights") int[] flights, @PathVariable("strides") int strides) throws JSONException {

        try{

            /*
            * Create a new stairwell and pass in the number of flights and stride count from the URL
            * */
            Stairwell stairwell = new Stairwell(flights,strides);

            /*
            * Create a JSON Object for response
            * call the totalStrides method
            * convert the JSON Object to a string as stated in Official Documentation for JSONObject
            * */
            String ans = new JSONObject().put("Anwser", stairwell.totalStrides()).toString();

            /*
            * Return the response to the user of the API with an 200 status code
            * */
            return new ResponseEntity(ans, HttpStatus.OK);


        } catch (Exception e){

            /*
            * Otherwise data passed into the API endpoint is not valid
            * return a 400 status and error message to the user of the API
            * via JSON content
            * */
            String error = new JSONObject().put("Error" , e.getMessage()).toString();

            return  new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }
    }

}
