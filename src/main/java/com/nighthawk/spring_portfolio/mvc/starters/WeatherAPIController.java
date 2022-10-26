package com.nighthawk.spring_portfolio.mvc.starters;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class WeatherAPIController {

    // GET request, no parameters
    @GetMapping("/starters/weather")
    public String weather(Model model) throws IOException, InterruptedException, ParseException {
        //online link https://rapidapi.com/spamakashrajtech/api/corona-virus-world-and-india-data/

        //rapid api setup:
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherbit-v1-mashape.p.rapidapi.com/forecast/3hourly?lat=34.0928&lon=-118.3287"))
                .header("X-RapidAPI-Key", "199e385baamshc0a4c645191a179p191ebdjsn70f0155c5394")
                .header("X-RapidAPI-Host", "weatherbit-v1-mashape.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        //rapid api call
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        //alternative #1: convert response.body() to java hash map
        var map = new ObjectMapper().readValue(response.body(), HashMap.class);

        //alternative #2: convert response.body() to JSON object
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

        //pass stats to view
        model.addAttribute("map", map);
        model.addAttribute("jo", jo);
        
        return "starters/weather";
    }

}
