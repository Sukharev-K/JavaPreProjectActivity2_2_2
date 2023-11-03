package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;



@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = (CarServiceImpl) carService;
    }

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(name = "count", required = false, defaultValue = "5") int count, ModelMap model) {
        //List<Car> cars = carService.getCars(count);
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
