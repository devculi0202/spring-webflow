package com.devculi.booking.hotel.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devculi.booking.hotel.entities.Hotel;

@Controller
public class SearchHotelController
{
    private List<Hotel> hotels = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Hotel hotel  = new Hotel(1, "Chi House", "ABC Distric");
        Hotel hotel1  = new Hotel(2, "Hi House", "XYZ Distric");
        hotels.add(hotel);
        hotels.add(hotel1);
    }


    @GetMapping(value = "/")
    public String getSearchHotelForm() {
        return "search-hotel";
    }

   @PostMapping(value = "/search-hotel")
   public String searchHotel(@RequestParam("nameHt") String nameHt, Model model) {

       Optional<Hotel> hotelOpt = hotels.stream().filter(hotel -> hotel.getName().equalsIgnoreCase(nameHt)).findFirst();
       if (hotelOpt.isPresent()) {
           model.addAttribute("hotelName", hotelOpt.get().getName());
           return "result-search";
       }
       return "result-search-empty";
   }

}


