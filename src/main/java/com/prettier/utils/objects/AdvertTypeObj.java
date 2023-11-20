package com.prettier.utils.objects;

import com.prettier.entity.concretes.AdvertType;
import com.prettier.repository.AdvertTypeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.results.graph.collection.internal.ListInitializerProducer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor

public class AdvertTypeObj {

    private final AdvertTypeRepository advertTypeRepository;

    public AdvertType createHousing() {
        return AdvertType.builder()
                .title("Konut").build();
    }
    public AdvertType createWorkPlace() {
        return AdvertType.builder()
                .title("Isyeri").build();
    }
    public AdvertType createPlot() {
        return AdvertType.builder()
                .title("Arsa").build();
    }
    public AdvertType createHousingProject() {
        return AdvertType.builder()
                .title("Konut Projeleri").build();
    }
    public AdvertType createBuilding() {
        return AdvertType.builder()
                .title("Bina").build();
    }
    public AdvertType createTimesharing() {
        return AdvertType.builder()
                .title("Devre Mulk").build();
    }
    public AdvertType createTouristFacility() {
        return AdvertType.builder()
                .title("Turistik Tesis").build();
    }

    public void fillAdvertTypeRepository(){
        advertTypeRepository.saveAll(List.of(createHousing()
                ,createWorkPlace()
                ,createPlot()
                ,createHousingProject()
                ,createBuilding()
                ,createTimesharing()
                ,createTouristFacility()
                ));
    }



}
