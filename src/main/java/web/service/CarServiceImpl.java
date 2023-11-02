package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private final List<Car> carList;

    public CarServiceImpl(){
        carList = new ArrayList<>();
        carList.add(new Car("Tayota", "Camry", 2022));
        carList.add(new Car("Honda", "CR-V", 2017));
        carList.add(new Car("Honda", "Accord", 2018));
        carList.add(new Car("Nissan", "Qashqai", 2021));
        carList.add(new Car("Opel", "Insignia", 2014));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return new ArrayList<>();
        }

        if (count >= carList.size()) {
            return carList;
        }

        return carList.subList(0, count);
    }

}
