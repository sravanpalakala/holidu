package com.holidu.interview.assignment;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class GetAggregateName {

	@GetMapping("/getAggregateName")
	public String getAggregateName(@RequestParam final Double latitude,@RequestParam final Double longitude, @RequestParam final Integer radius) throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.ACCEPTED);
		String result = "";
		try {

			RestTemplate restTemplate = new RestTemplate();
			//List<Double> list = Circle.drawCircle(-73.84421522, 40.77020969, 160934);
			List<Double> list = Circle.drawCircle(longitude, latitude, radius);

			double startLongitude = longitude;
			double endLongitude = list.get(list.size() - 2);
			//System.out.println("start: " + startLongitude + " end:" + endLongitude);
			String fooResourceUrl = "https://data.cityofnewyork.us/resource/uvpi-gqnh.json?$where=longitude BETWEEN  "
					+ startLongitude + " and " + endLongitude;

			response = restTemplate.getForEntity(fooResourceUrl, String.class);

			ObjectMapper objectMapper = new ObjectMapper();

			TreeModel[] myObjects = objectMapper.readValue(response.getBody(), TreeModel[].class);
			//System.out.println(" spc common:" + myObjects.length);

			result = new Aggregation().findAggregation(myObjects);

		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		
		
	}
	  

